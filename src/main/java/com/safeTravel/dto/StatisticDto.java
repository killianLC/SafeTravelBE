package com.safeTravel.dto;

import java.util.Set;

import com.safeTravel.entity.City;
import lombok.Data;

@Data
public class StatisticDto {
    private Long id;
    private CityDto cityDto;
    private Set<CriterionDto> criteriaDto;
}
