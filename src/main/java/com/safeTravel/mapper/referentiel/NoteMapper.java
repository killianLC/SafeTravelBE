package com.safeTravel.mapper.referentiel;

import com.safeTravel.dto.NoteDto;
import com.safeTravel.entity.Note;
import com.safeTravel.mapper.GenericMapperCyclingAvoiding;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface NoteMapper extends GenericMapperCyclingAvoiding<Note, NoteDto> {
}
