package com.safeTravel.dto;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VilleDto {
    private Long id;
    private String nom;
    private List<CommentaireDto> commentaireList;
    private StatistiqueDto statistiqueDto;

}
