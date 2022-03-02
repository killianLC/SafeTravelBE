package com.safeTravel.service.impl;

import com.safeTravel.dto.CityClassementDto;
import com.safeTravel.dto.CityDto;
import com.safeTravel.dto.ReducedCityDto;
import com.safeTravel.entity.City;
import com.safeTravel.mapper.referentiel.CityMapper;
import com.safeTravel.mapper.referentiel.ReducedCityMapper;
import com.safeTravel.repository.CityRepository;
import com.safeTravel.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ReducedCityMapper reducedCityMapper;

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

            if(!response.getBody().contains("\"nom\":\""+name)) {
                throw new EntityNotFoundException();
            } else {
                City newCity = new City();
                newCity.setName(name);

                this.cityRepository.save(newCity);
                return cityMapper.toDto(newCity);
            }
        }

        this.cityRepository.save(city.get());
        return cityMapper.toDto(city.get());
    }

    @Override
    public Double getRatingAverageByName(String name) {
        return cityRepository.getRatingAverageByName(name);
    }

    @Override
    public List<CityClassementDto> getTop10ByNotesDesc() { return cityRepository.findTop10ByOrderByNotesDesc(PageRequest.of(0,10)); }
}
