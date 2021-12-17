package com.safeTravel.controller;

import com.safeTravel.entity.User;
import com.safeTravel.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {
    private UserRepository userRepository;
    /**
     * GET /competences : Get all competences
     *
     * @return list of competences with status 200(OK)
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllCompetences() {
        return userRepository.findAll();
    }
}
