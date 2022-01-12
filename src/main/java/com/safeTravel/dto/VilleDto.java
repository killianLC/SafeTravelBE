package com.safeTravel.dto;

import java.util.List;
import java.util.Set;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
public class VilleDto {
    private Long id;
    private String nom;
    private List<CommentaireDto> commentaireList;
    private StatistiqueDto statistiqueDto;
}
