package com.safeTravel.service;

import com.safeTravel.dto.UserDto;

import javax.transaction.Transactional;

@Transactional
public interface UserService extends ServiceShared<UserDto, Long> {
}
