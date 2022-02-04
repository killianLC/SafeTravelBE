package com.safeTravel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class TripDto {
    private Long id;
    private Set<StepDto> steps;
    private Set<UserDto> participants;
    private Set<CityDto> citiesDto;
    private UserDto userDto;

}
