package com.safeTravel.mapper.referentiel;

import com.safeTravel.dto.StepDto;
import com.safeTravel.dto.StepWithoutTripDto;
import com.safeTravel.entity.Step;
import com.safeTravel.mapper.GenericMapperCyclingAvoiding;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StepWithoutTripMapper extends GenericMapperCyclingAvoiding<Step, StepWithoutTripDto> {
}