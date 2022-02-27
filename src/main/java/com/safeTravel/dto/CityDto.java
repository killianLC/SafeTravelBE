package com.safeTravel.dto;

import com.safeTravel.entity.Comment;
import com.safeTravel.entity.Note;
import com.safeTravel.entity.Step;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

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
