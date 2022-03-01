package com.safeTravel.mapper.referentiel;

import com.safeTravel.dto.ReducedCityDto;
import com.safeTravel.entity.City;
import com.safeTravel.mapper.GenericMapperCyclingAvoiding;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")

public interface ReducedCityMapper extends GenericMapperCyclingAvoiding<City, ReducedCityDto> {
}
