package com.safeTravel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
public class UserDto {

    private String email;
    private String nom;
    private String prenom;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

  //  private Set<VoyageDto> voyageDtoSet;
}
