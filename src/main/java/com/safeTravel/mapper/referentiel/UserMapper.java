package com.safeTravel.mapper.referentiel;

import com.safeTravel.dto.UserDto;
import com.safeTravel.entity.User;
import com.safeTravel.mapper.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<User, UserDto> {
}
