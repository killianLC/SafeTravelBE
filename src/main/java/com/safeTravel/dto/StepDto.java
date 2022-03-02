package com.safeTravel.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class StepDto {
    private Long id;

    private LocalDate date;

    @JsonIgnoreProperties({"steps","notes","comments"})
    private CityDto city;

    private TripDto trip;
}