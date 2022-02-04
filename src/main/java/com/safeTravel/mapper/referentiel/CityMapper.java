package com.safeTravel.mapper.referentiel;

import com.safeTravel.dto.CityDto;
import com.safeTravel.entity.City;
import com.safeTravel.mapper.CycleAvoidingMappingContext;
import com.safeTravel.mapper.GenericMapperCyclingAvoiding;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CommentMapper.class)
public interface CityMapper extends GenericMapperCyclingAvoiding<City, CityDto> {

    @Override
    @Mapping(source = "city.comments", target = "commentsDto")
    default CityDto toDto(City city) {
        return GenericMapperCyclingAvoiding.super.toDto(city);
    }

    @Override
    @Mapping(source = "city.comments", target = "commentsDto")
    CityDto toDto(City city, CycleAvoidingMappingContext cycleAvoidingMappingContext);
}