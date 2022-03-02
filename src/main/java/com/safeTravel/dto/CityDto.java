package com.safeTravel.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"steps","notes"})
public class CityDto {
    private Long id;

    private String name;

    @EqualsAndHashCode.Exclude
    private List<CommentDto> comments;

    @EqualsAndHashCode.Exclude
    private List<NoteDto> notes;

    @EqualsAndHashCode.Exclude
    private List<StepDto> steps;
}
