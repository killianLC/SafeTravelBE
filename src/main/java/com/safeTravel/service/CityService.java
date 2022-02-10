package com.safeTravel.service;

import com.safeTravel.dto.CityDto;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CityService extends ServiceShared<CityDto, Long> {
    CityDto getByName(String name);

    Double getRatingAverageByName(String name);

    List<CityDto> getTop10ByNotesDesc();
}
