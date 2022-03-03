package com.safeTravel.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.safeTravel.entity.Trip;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class TripDto {

    public TripDto(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    private Long id;

    private String description;

    @JsonIgnoreProperties({"comments","roles","trips","citiesFavoris"})
    private UserDto organisateur;

    private Set<ParticipantDto> participants;

    @JsonIgnoreProperties({"trip"})
    private Set<StepDto> steps;
}