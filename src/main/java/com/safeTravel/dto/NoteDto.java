package com.safeTravel.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
public class NoteDto {

    private Long id;

    private Double note;

    private LocalDate date;

    private CriterionDto criterion;
}
