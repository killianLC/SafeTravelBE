package com.safeTravel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CritereDto {
    private Long id;
    private String name;
    private Double score;
    private CityDto cityDto;
}
