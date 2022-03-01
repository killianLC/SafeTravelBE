package com.safeTravel.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
public class CityDto {
    private Long id;
    private String name;
    @JsonIgnoreProperties(value = "city")
    private List<CommentDto> comments;
    private List<NoteDto> notes;
}
