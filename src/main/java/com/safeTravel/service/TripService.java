package com.safeTravel.service;

import com.safeTravel.dto.StepWithoutTripDto;
import com.safeTravel.dto.TripDto;
import com.safeTravel.dto.create.StepCreationDto;
import com.safeTravel.dto.create.TripCreationDto;

import java.util.List;

public interface TripService extends ServiceShared<TripDto, Long> {
    List<TripDto> getUserTrips(Long userId);
    Long create(TripCreationDto dto);
    Boolean isParticipant(Long utilisateurId, Long tripId);
    void deleteStep(Long utilisateurId, Long tripId, Long stepId);
    StepWithoutTripDto createStep(Long utilisateurId, Long tripId, StepCreationDto stepCreationDto);
    void modifyDescription(Long utilisateurId, Long tripId, String description);
    void deleteTripSecure(Long organisateurId, Long tripToDelete);
}
