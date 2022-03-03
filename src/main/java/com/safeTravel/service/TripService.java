package com.safeTravel.service;

import com.safeTravel.dto.StepDto;
import com.safeTravel.dto.StepWithoutTripDto;
import com.safeTravel.dto.TripDto;
import com.safeTravel.dto.create.StepCreationDto;
import com.safeTravel.dto.create.TripCreationDto;
import com.safeTravel.dto.delete.StepDeleteDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface TripService extends ServiceShared<TripDto, Long> {
    List<TripDto> getUserTrips(Long userId);
    Long create(TripCreationDto dto);
    Boolean isParticipant(Long utilisateurId, Long tripId);
    void deleteStep(Long utilisateurId, Long tripId, Long stepId);
    StepWithoutTripDto createStep(Long utilisateurId, Long tripId, StepCreationDto stepCreationDto);
}
