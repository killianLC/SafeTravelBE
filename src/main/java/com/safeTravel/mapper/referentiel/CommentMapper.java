package com.safeTravel.mapper.referentiel;

import com.safeTravel.dto.CityDto;
import com.safeTravel.dto.CommentDto;
import com.safeTravel.entity.City;
import com.safeTravel.entity.Comment;
import com.safeTravel.mapper.CycleAvoidingMappingContext;
import com.safeTravel.mapper.GenericMapperCyclingAvoiding;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper extends GenericMapperCyclingAvoiding<Comment, CommentDto> {
    @Override
    @Mapping(source = "comment.city", target = "cityDto")
    default CommentDto toDto(Comment comment) {
        return GenericMapperCyclingAvoiding.super.toDto(comment);
    }

    @Override
    @Mapping(source = "comment.city", target = "cityDto")
    CommentDto toDto(Comment comment, CycleAvoidingMappingContext cycleAvoidingMappingContext);
}