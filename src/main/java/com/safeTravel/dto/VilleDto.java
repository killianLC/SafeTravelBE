package com.safeTravel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class VilleDto {
    private Long id;
    private String nom;
    private List<CommentaireDto> commentaireList;
    private StatistiqueDto statistiqueDto;
}
