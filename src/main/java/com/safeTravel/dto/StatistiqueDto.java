package com.safeTravel.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
public class StatistiqueDto {
    private Set<CritereDto> criteresDto;
    private Double noteSafeTravel;
}
