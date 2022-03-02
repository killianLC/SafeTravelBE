package com.safeTravel.dto.delete;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class FavorisDeleteDto {
    private Long userId;

    private Long favorisId;
}
