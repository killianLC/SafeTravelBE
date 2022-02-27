package com.safeTravel.mapper.referentiel;

import com.safeTravel.dto.CommentDto;
import com.safeTravel.entity.Comment;
import com.safeTravel.mapper.GenericMapperCyclingAvoiding;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CommentMapper extends GenericMapperCyclingAvoiding<Comment, CommentDto> {
}