package com.safeTravel.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
public class CommentDto {
    private Long id;
    private String description;
    private LocalDate date;
    private Integer rating;
    private ReducedUserDto user;
    private ReducedCityDto city;
}
