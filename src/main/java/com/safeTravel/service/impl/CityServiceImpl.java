package com.safeTravel.service.impl;

import com.safeTravel.dto.*;
import com.safeTravel.entity.*;
import com.safeTravel.mapper.referentiel.CityMapper;
import com.safeTravel.mapper.referentiel.ReducedCityMapper;
import com.safeTravel.repository.CityRepository;
import com.safeTravel.repository.CriterionRepository;
import com.safeTravel.repository.NoteRepository;
import com.safeTravel.repository.UserRepository;
import com.safeTravel.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@Slf4j
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ReducedCityMapper reducedCityMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private CriterionRepository criterionRepository;

    @Override
    public List<CityDto> getAll() {
        return cityMapper.toDtos(cityRepository.findAll());
    }

    public List<ReducedCityDto> getAllReducedCity() {
        return reducedCityMapper.toDtos(cityRepository.findAll());
    }

    @Override
    public CityDto getById(Long id) {
        return cityMapper.toDto(cityRepository.getById(id));
    }

    @Override
    public CityDto create(CityDto dto) {
        return cityMapper.toDto(cityRepository.save(cityMapper.toEntity(dto)));
    }

    @Override
    public CityDto update(CityDto dto) {
        return cityMapper.toDto(cityRepository.save(cityMapper.toEntity(dto)));
    }

    @Override
    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public CityDto getByName(String name) {
        Optional<City> city = cityRepository.findByName(name);

        if(!city.isPresent()) {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity("https://geo.api.gouv.fr/communes?nom=" + name + "&fields=nom,code,codesPostaux,codeDepartement,codeRegion,population&format=json&geometry=centre", String.class);

            if(response.getBody().contains("\"nom\":\""+name)) {
                City newCity = new City();
                newCity.setName(name);

                this.cityRepository.save(newCity);

                List<Criterion> criterionList = this.criterionRepository.findAll();
                criterionList.forEach((criterion) -> {
                    this.addIfNotExistNoteByCriterionAndCurrentDate(newCity, criterion, LocalDate.now().minusDays(1));
                });

                return cityMapper.toDto(newCity);
            } else {
                throw new EntityNotFoundException();
            }
        }

        List<Criterion> criterionList = this.criterionRepository.findAll();
        criterionList.forEach((criterion) -> {
            this.addIfNotExistNoteByCriterionAndCurrentDate(city.get(), criterion, LocalDate.now());
        });

        this.cityRepository.save(city.get());
        return cityMapper.toDto(city.get());
    }

    public void addIfNotExistNoteByCriterionAndCurrentDate(City city, Criterion criterion, LocalDate currentDate) {
        Optional<Note> note = this.noteRepository.findByCriterionAndDateAndCity(criterion, currentDate, city);

        if(!note.isPresent()) {
            Note newNote = new Note();
            newNote.setCriterion(criterion);
            newNote.setDate(currentDate);
            newNote.setCity(city);
            newNote.setNote(this.calculateNoteForCriterionAndCity(criterion, city));
            this.noteRepository.save(newNote);
        }
        else {
            Double newNote = this.calculateNoteForCriterionAndCity(criterion, city);
            // BOUCHON
            if(note.get().getNote() != newNote && !note.get().getCriterion().getType().equals("METEO_NOTES")) {
                note.get().setNote(newNote);
                this.noteRepository.save(note.get());
            }
        }
    }

    public Double calculateNoteForCriterionAndCity(Criterion criterion, City city) {
        switch(criterion.getType()) {
            case "USER_NOTES": return this.getRatingAverageByName(city.getName());
            case "METEO_NOTES": return this.getMeteoNoteByName(city.getName());
            default: return null;
        }
    }

    @Override
    public Double getRatingAverageByName(String name) {
        return cityRepository.getRatingAverageByName(name);
    }

    @Override
    public Double getMeteoNoteByName(String name) {
        Random r = new Random();
        double randomValue = r.nextInt(4) + 1;

        return randomValue;
    }

    @Override
    public List<NoteQueryDto> getUsersRatingsByName(String name) {
        return cityRepository.getUsersRatingsByName(name);
    }

    @Override
    public List<NoteQueryDto> getMeteoRatingsByName(String name) {
        return cityRepository.getMeteoRatingsByName(name);
    }


    @Override
    public List<CityClassementDto> getTop10ByNotesDesc() {
        return cityRepository.findTop10ByOrderByNotesDesc(PageRequest.of(0,10));
    }

    @Override
    public void createFavoris(Long cityId, Long userId) {
        Optional<City> city = cityRepository.findById(cityId);

        if(!city.isPresent()) throw new EntityNotFoundException("La ville n'existe pas");

        Optional<User> user = userRepository.findById(userId);

        if(!user.isPresent()) throw new EntityNotFoundException("L'utilisateur n'existe pas");

        user.get().getCitiesFavoris().add(city.get());

        this.userRepository.save(user.get());
    }

    @Override
    public void deleteFavoris(Long cityId, Long userId) {
        Optional<City> city = cityRepository.findById(cityId);

        if(!city.isPresent()) throw new EntityNotFoundException("La ville n'existe pas");

        Optional<User> user = userRepository.findById(userId);

        if(!user.isPresent()) throw new EntityNotFoundException("L'utilisateur n'existe pas");

        user.get().getCitiesFavoris().remove(city.get());

        this.userRepository.save(user.get());
    }

    @Override
    public Boolean isFavoris(Long cityId, Long userId) {
        Optional<City> city = cityRepository.findById(cityId);

        if(!city.isPresent()) throw new EntityNotFoundException("La ville n'existe pas");

        Optional<User> user = userRepository.findById(userId);

        if(!user.isPresent()) throw new EntityNotFoundException("L'utilisateur n'existe pas");

        return user.get().getCitiesFavoris().contains(city.get());
    }

    @Override
    public Double getGlobalNote(String name) {
        return this.cityRepository.getGlobalNote(name);
    }
}
