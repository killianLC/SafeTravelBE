package com.safeTravel.service;

import com.safeTravel.dto.TripDto;
import com.safeTravel.dto.create.TripCreationDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface TripService extends ServiceShared<TripDto, Long> {
    List<TripDto> getUserTrips(Long userId);
    Long create(TripCreationDto dto);
    Boolean isParticipant(Long utilisateurId, Long tripId);
}
