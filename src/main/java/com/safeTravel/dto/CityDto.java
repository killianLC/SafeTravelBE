package com.safeTravel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CityDto {
    private Long id;
    private String name;
    private List<CommentDto> commentsDto;
    private StatisticDto statisticDto;
}
