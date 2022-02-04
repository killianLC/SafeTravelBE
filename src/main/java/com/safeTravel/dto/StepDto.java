package com.safeTravel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class StepDto {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private CityDto cityDto;
    private TripDto tripDto;
}
