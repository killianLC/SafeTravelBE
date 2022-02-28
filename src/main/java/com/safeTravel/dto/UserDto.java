package com.safeTravel.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @JsonIgnoreProperties("users")
    private Set<RoleDto> rolesDto;

    @JsonIgnoreProperties("user")
    private Set<TravelDto> travels;

    @JsonIgnoreProperties("user")
    private Set<CommentDto> comments;
}

