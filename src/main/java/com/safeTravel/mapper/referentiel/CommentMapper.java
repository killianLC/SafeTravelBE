package com.safeTravel.mapper.referentiel;

import com.safeTravel.dto.CommentDto;
import com.safeTravel.entity.Comment;
import com.safeTravel.mapper.GenericMapperCyclingAvoiding;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper extends GenericMapperCyclingAvoiding<Comment, CommentDto> {
}