package com.safeTravel.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ParticipantDto {
    private Long id;

    private ReducedUserDto user;

    private TripDto trip;

    private Boolean statut = false;
}
