package com.safeTravel.mapper.referentiel;

import com.safeTravel.dto.ParticipantDto;
import com.safeTravel.entity.Participant;
import com.safeTravel.mapper.GenericMapperCyclingAvoiding;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ParticipantMapper extends GenericMapperCyclingAvoiding<Participant, ParticipantDto> {
}
