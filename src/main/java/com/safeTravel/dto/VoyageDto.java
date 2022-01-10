package com.safeTravel.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
public class VoyageDto {
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private List<VilleDto> villeDto;

}
