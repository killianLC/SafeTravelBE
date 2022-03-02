package com.safeTravel.service;

import com.safeTravel.dto.CityClassementDto;
import com.safeTravel.dto.CityDto;
import com.safeTravel.dto.ReducedCityDto;

import java.util.List;

public interface CityService extends ServiceShared<CityDto, Long> {
    CityDto getByName(String name);
    List<ReducedCityDto> getAllReducedCity();
    Double getRatingAverageByName(String name);
    void createFavoris(Long cityId, Long userId);
    void deleteFavoris(Long cityId, Long userId);
    Boolean isFavoris(Long cityId, Long userId);
    List<CityClassementDto> getTop10ByNotesDesc();
}
