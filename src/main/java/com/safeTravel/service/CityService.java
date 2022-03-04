package com.safeTravel.service;

import com.safeTravel.dto.*;

import java.util.List;

public interface CityService extends ServiceShared<CityDto, Long> {
    CityDto getByName(String name);
    List<ReducedCityDto> getAllReducedCity();
    Double getRatingAverageByName(String name);
    Double getMeteoAverageByName(String name);
    List<NoteQueryDto> getUsersRatingsByName(String name);
    List<NoteQueryDto> getMeteoRatingsByName(String name);
    void createFavoris(Long cityId, Long userId);
    void deleteFavoris(Long cityId, Long userId);
    Boolean isFavoris(Long cityId, Long userId);
    List<CityClassementDto> getTop10ByNotesDesc();
}
