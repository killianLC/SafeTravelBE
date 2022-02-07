package com.safeTravel.dto;

import com.safeTravel.entity.User;
import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
public class RoleDto {
    private Long id;
    private String name;
    private Set<User> users;
}
