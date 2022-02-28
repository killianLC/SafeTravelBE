package com.safeTravel.dto;
import lombok.*;

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
