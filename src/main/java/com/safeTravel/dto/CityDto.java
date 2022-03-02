package com.safeTravel.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
public class CityDto {
    private Long id;

    private String name;

    private List<CommentDto> comments;

    private List<NoteDto> notes;

    private List<StepDto> steps;
}
