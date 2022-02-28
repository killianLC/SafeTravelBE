package com.safeTravel.mapper.referentiel;

import com.safeTravel.dto.UserDto;
import com.safeTravel.entity.User;
import com.safeTravel.mapper.GenericMapperCyclingAvoiding;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper extends GenericMapperCyclingAvoiding<User, UserDto> {
}
