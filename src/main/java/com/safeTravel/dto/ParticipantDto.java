package com.safeTravel.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ParticipantDto {
    private Long id;

    @JsonIgnoreProperties({"comments","roles","trips","citiesFavoris"})
    private UserDto user;

    private Boolean statut;
}
