package com.safeTravel.dto.update;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ParticipantUpdateDto {
    private Long participantId;

    private Long tripId;
}
