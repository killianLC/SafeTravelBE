package com.safeTravel.dto.delete;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StepDeleteDto {
    private Long stepId;

    private Long tripId;
}
