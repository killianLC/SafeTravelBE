package com.safeTravel.service.impl;

import com.safeTravel.dto.CityDto;
import com.safeTravel.mapper.referentiel.CityMapper;
import com.safeTravel.repository.CityRepository;
import com.safeTravel.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<CityDto> getAll() {
        List uE = cityRepository.findAll();
        List uD = cityMapper.toDtos(cityRepository.findAll());
        return cityMapper.toDtos(cityRepository.findAll());
    }

    @Override
    public CityDto getById(Long id) {
        return null;
    }

    @Override
    public CityDto create(CityDto dto) {
        return null;
    }

    @Override
    public CityDto update(CityDto dto) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public CityDto getByName(String name) {
        return cityMapper.toDto(cityRepository.findByName(name));
    }
}
