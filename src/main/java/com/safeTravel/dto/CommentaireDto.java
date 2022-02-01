package com.safeTravel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentaireDto {
    private Long id;
    private UserDto userDto;
    private VilleDto villeDto;
    private float note;
}
