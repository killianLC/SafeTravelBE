package com.safeTravel.mapper.referentiel;

import com.safeTravel.dto.UserDto;
import com.safeTravel.entity.User;
import com.safeTravel.mapper.GenericMapper;
import com.safeTravel.mapper.GenericMapperCyclingAvoiding;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper{
    UserDto toDto(User e);
    User toEntity(UserDto d);
    List<UserDto> toDtos(List<User> e);
    List<User> toEntities(List<UserDto> d);
}
