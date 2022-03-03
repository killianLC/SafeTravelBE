package com.safeTravel.dto.delete;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ParticipantDeleteDto {
    private Long participantId;

    private Long tripId;
}