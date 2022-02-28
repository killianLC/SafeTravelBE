package com.safeTravel.service;

import com.safeTravel.dto.CityClassementDto;
import com.safeTravel.dto.CityDto;

import java.util.List;

public interface CityService extends ServiceShared<CityDto, Long> {
    CityDto getByName(String name);

    Double getRatingAverageByName(String name);

    List<CityClassementDto> getTop10ByNotesDesc();
}
