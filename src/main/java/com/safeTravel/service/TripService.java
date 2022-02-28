package com.safeTravel.service;

import com.safeTravel.dto.TripDto;

import java.util.List;

public interface TripService extends ServiceShared<TripDto, Long> {
    List<TripDto> getUserTrips(Long userId);
}
