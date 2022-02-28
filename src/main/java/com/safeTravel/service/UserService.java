package com.safeTravel.service;

import com.safeTravel.dto.UserDto;

public interface UserService extends ServiceShared<UserDto, Long> {
    void updateFirstnameAndLastname(Long id, String firstname, String lastname);

    void updatePassword(Long id, String password);
}
