package com.safeTravel.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
public class CityDto {
    private Long id;
    private String name;
    private Set<CommentDto> commentsDto;
    private StatisticDto statisticDto;
}
