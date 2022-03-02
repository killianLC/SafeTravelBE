package com.safeTravel.mapper.referentiel;

import com.safeTravel.dto.StepDto;
import com.safeTravel.entity.Step;
import com.safeTravel.mapper.GenericMapperCyclingAvoiding;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StepMapper extends GenericMapperCyclingAvoiding<Step, StepDto> {
}
