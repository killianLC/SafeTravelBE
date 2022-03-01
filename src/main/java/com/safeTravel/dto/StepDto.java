package com.safeTravel.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
public class StepDto {
    private Long id;

    private LocalDate date;

    private CityDto city;

    @EqualsAndHashCode.Exclude
    private TripDto trip;
}
