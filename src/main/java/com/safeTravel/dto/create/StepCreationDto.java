package com.safeTravel.dto.create;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
public class StepCreationDto {
    private LocalDate date;

    private String cityName;
}
