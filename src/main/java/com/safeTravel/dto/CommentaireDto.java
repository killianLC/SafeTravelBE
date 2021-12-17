package com.safeTravel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentaireDto {
    private Long id;
    private UserDto userDto;
    private VilleDto villeDto;
    private float note;
}
