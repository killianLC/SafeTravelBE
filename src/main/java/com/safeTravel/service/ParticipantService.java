package com.safeTravel.service;

import com.safeTravel.dto.ParticipantDto;
import com.safeTravel.dto.TripDto;
import com.safeTravel.dto.delete.ParticipantDeleteDto;
import com.safeTravel.dto.update.ParticipantUpdateDto;

import java.util.List;

public interface ParticipantService extends ServiceShared<ParticipantDto, Long> {
    void deleteByIdForATrip(ParticipantDeleteDto participantDeleteDto);
    void acceptParticipant(ParticipantUpdateDto participantUpdateDto);
    List<ParticipantDto> getAllForTrip(Long tripId);
    List<TripDto> getTripsUserParticipate(Long userUid);
}
