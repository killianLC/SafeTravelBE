package com.safeTravel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class StatisticDto {
    private Long id;
    private String name;
    private CityDto city;
    private Set<CriterionDto> criteria;
}
