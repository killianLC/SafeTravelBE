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

    private LocalDate date;

    private ReducedCityDto city;

    private TripDto trip;
}
