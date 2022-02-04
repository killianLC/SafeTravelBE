package com.safeTravel.mapper.referentiel;

import com.safeTravel.dto.CityDto;
import com.safeTravel.entity.City;
import com.safeTravel.mapper.GenericMapperCyclingAvoiding;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper extends GenericMapperCyclingAvoiding<City, CityDto> {
}