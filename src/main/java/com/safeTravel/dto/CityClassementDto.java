package com.safeTravel.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityClassementDto {
    private Long id;
    private String name;
    private Double note;
}