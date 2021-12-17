package com.safeTravel.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoyageDto {
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private List<VilleDto> villeDto;

}
