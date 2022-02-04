package com.safeTravel.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class CritereDto {
    private Long id;
    private String name;
    private Double score;
    private CityDto cityDto;
}
