package com.safeTravel.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class TripDto {
    private Long id;

    private String description;

    @JsonIgnoreProperties({"comments","roles","trips","citiesFavoris"})
    private UserDto organisateur;

    private Set<ParticipantDto> participants;

    @JsonIgnoreProperties({"trip"})
    private Set<StepDto> steps;
}