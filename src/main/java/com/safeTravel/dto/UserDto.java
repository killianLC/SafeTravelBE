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
@JsonIgnoreProperties({"comments","roles","trips"})
public class UserDto {
    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @EqualsAndHashCode.Exclude
    private Set<RoleDto> roles;
    @EqualsAndHashCode.Exclude
    private Set<TripDto> trips;
    @EqualsAndHashCode.Exclude
    private Set<CommentDto> comments;
}

