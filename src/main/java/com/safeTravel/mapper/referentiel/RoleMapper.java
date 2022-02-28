package com.safeTravel.mapper.referentiel;

import com.safeTravel.dto.RoleDto;
import com.safeTravel.entity.Role;
import com.safeTravel.mapper.GenericMapperCyclingAvoiding;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RoleMapper extends GenericMapperCyclingAvoiding<Role, RoleDto> {
}
