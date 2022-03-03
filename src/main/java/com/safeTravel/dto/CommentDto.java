package com.safeTravel.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CommentDto {
    private Long id;
    private String description;
    private LocalDate date;
    private Integer rating;
    @JsonIgnoreProperties({"comments"})
    private UserDto user;
    @JsonIgnoreProperties({"comments"})
    private CityDto city;
}
