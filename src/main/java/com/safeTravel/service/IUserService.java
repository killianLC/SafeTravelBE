package com.safeTravel.service;

import com.safeTravel.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void addNewUser();
}
