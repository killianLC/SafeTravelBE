package com.safeTravel.service;

import com.safeTravel.dto.TripDto;
import com.safeTravel.dto.create.TripCreationDto;

import java.util.List;

public interface TripService extends ServiceShared<TripDto, Long> {
    List<TripDto> getUserTrips(Long userId);
    Long create(TripCreationDto dto);
}
