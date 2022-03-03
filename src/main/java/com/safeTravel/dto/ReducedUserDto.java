package com.safeTravel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReducedUserDto {
    private Long id;
    private String firstname;
    private String lastname;
}
