package com.safeTravel.dto;

import com.safeTravel.entity.User;
import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
public class TripDto {
    private Long id;

    private String description;

    private User organisateur;

    @EqualsAndHashCode.Exclude
    private Set<StepDto> steps;
}