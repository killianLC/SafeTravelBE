package com.safeTravel.dto;

import java.util.Set;

import lombok.Data;

@Data
public class StatisticDto {
    private Set<CritereDto> criteresDto;
    private Double noteSafeTravel;
}
