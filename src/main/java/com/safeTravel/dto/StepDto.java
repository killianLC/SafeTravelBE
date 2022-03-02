package com.safeTravel.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"trip"})
public class StepDto {
    private Long id;

    private LocalDate date;

    private CityDto city;

    private TripDto trip;
}