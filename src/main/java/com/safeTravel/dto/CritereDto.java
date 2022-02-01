package com.safeTravel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CritereDto {
    private Long id;
    private String nom;
    private Double score;
    private VilleDto villeDto;
}
