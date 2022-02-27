package com.safeTravel.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReducedUserDto {
    private Long id;
    private String firstname;
    private String lastname;
}
