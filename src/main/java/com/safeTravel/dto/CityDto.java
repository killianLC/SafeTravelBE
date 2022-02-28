package com.safeTravel.dto;

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
    private List<CommentDto> comments;
    private List<NoteDto> notes;
}
