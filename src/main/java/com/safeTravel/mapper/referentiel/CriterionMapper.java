package com.safeTravel.mapper.referentiel;

import com.safeTravel.dto.CriterionDto;
import com.safeTravel.entity.Criterion;
import com.safeTravel.mapper.GenericMapperCyclingAvoiding;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CriterionMapper extends GenericMapperCyclingAvoiding<Criterion, CriterionDto> {
}