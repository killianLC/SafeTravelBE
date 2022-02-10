package com.safeTravel.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class CriterionDto {
    private Long id;
    private String name;
    private Double rating;
    private StatisticDto statistic;
}
