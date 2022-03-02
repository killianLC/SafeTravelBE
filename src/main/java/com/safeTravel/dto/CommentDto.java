package com.safeTravel.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties(value = "comments")
    private UserDto user;
    @JsonIgnoreProperties(value = "comments")
    private CityDto city;
}
