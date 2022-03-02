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
@JsonIgnoreProperties({"city"})
public class CommentDto {
    private Long id;
    private String description;
    private LocalDate date;
    private Integer rating;
    private UserDto user;
    private CityDto city;
}
