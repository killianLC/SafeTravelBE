package com.safeTravel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TripQueryDto {

    private Long id;

    private String description;
}