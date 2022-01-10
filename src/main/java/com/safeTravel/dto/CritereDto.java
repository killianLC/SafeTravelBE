package com.safeTravel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
public class CritereDto {
    private Long id;
    private String nom;
    private Double score;
    private VilleDto villeDto;
}
