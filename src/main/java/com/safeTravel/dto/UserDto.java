package com.safeTravel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String email;
    private String nom;
    private String prenom;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private Set<VoyageDto> voyageDtoSet;
}
