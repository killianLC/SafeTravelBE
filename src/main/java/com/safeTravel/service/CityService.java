package com.safeTravel.service;

import com.safeTravel.dto.CityDto;

import javax.transaction.Transactional;

@Transactional
public interface CityService extends ServiceShared<CityDto, Long> {
    CityDto getByName(String name);
}
