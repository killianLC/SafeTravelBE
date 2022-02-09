package com.safeTravel.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
public class StepDto {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer stepNumber;
    private CityDto city;
    private TripDto trip;
}
