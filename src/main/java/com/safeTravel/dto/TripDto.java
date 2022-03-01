package com.safeTravel.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.safeTravel.entity.Participant;
import com.safeTravel.entity.Step;
import com.safeTravel.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
public class TripDto {
    private Long id;

    private String description;

    @JsonIgnoreProperties(value = "trip")
    private Set<StepDto> steps;

    @JsonIgnoreProperties(value = "trip")
    private Set<ParticipantDto> participants;
}
