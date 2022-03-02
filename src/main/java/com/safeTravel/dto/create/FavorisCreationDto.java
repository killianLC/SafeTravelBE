package com.safeTravel.dto.create;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class FavorisCreationDto {
    private Long userId;

    private Long cityId;
}
