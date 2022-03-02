package com.safeTravel.dto.create;

import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
public class TripCreationDto {
    private Long id;

    private String description;

    private Long organisateurId;

    private Set<StepCreationDto> steps;
}
