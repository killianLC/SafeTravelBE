package com.safeTravel.service.impl;

import com.safeTravel.dto.CityClassementDto;
import com.safeTravel.dto.CityDto;
import com.safeTravel.mapper.referentiel.CityMapper;
import com.safeTravel.repository.CityRepository;
import com.safeTravel.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return cityMapper.toDto(cityRepository.findByName(name));
    }

    @Override
    public Double getRatingAverageByName(String name) {
        return cityRepository.getRatingAverageByName(name);
    }

    @Override
    public List<CityClassementDto> getTop10ByNotesDesc() { return cityRepository.findTop10ByOrderByNotesDesc(PageRequest.of(0,10)); }
}
