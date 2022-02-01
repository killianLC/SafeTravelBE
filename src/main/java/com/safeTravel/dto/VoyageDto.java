package com.safeTravel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class VoyageDto {
    private Long id;
    private Set<EtapeDto> etapes;
    private Set<UserDto> participants;
    private List<VilleDto> villeDto;
    private UserDto userDto;

}
