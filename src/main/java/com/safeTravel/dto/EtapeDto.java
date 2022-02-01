package com.safeTravel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class EtapeDto {
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private VilleDto villeDto;
    private VoyageDto voyageDto;
}
