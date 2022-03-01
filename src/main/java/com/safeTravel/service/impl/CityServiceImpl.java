package com.safeTravel.service.impl;

import com.safeTravel.dto.CityClassementDto;
import com.safeTravel.dto.CityDto;
import com.safeTravel.entity.City;
import com.safeTravel.mapper.referentiel.CityMapper;
import com.safeTravel.repository.CityRepository;
import com.safeTravel.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<CityDto> getAll() {
        return cityMapper.toDtos(cityRepository.findAll());
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
        if(name.equals("Oui")) {
            throw new EntityNotFoundException();
        }

        City city = cityRepository.findByName(name).orElseGet(() -> {
            City newCity = new City();
            newCity.setName(name);
            return newCity;
        });

        this.cityRepository.save(city);

        return cityMapper.toDto(city);
    }

    @Override
    public Double getRatingAverageByName(String name) {
        return cityRepository.getRatingAverageByName(name);
    }

    @Override
    public List<CityClassementDto> getTop10ByNotesDesc() { return cityRepository.findTop10ByOrderByNotesDesc(PageRequest.of(0,10)); }
}
