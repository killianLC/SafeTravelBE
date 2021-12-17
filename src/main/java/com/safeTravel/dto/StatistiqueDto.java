package com.safeTravel.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatistiqueDto {
    private Set<CritereDto> criteresDto;
    private double noteSafeTravel;
}
