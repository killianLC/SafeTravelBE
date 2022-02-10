package com.safeTravel.dto;

import com.safeTravel.entity.Step;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
public class CityDto {
    private Long id;
    private String name;
    private Set<CommentDto> comments;
    private Set<Step> steps;
    private StatisticDto statistic;
}
