package com.safeTravel.mapper.referentiel;

import com.safeTravel.dto.TripDto;
import com.safeTravel.entity.Trip;
import com.safeTravel.mapper.GenericMapperCyclingAvoiding;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TripMapper extends GenericMapperCyclingAvoiding<Trip, TripDto> {
}
