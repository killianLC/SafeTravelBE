package com.safeTravel.controller;

import com.safeTravel.dto.UserDto;
import com.safeTravel.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Endpoint /users/{id} type GET
     *
     * @return UserDto found thanks to his id
     */
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.FOUND)
    public UserDto getById(@PathVariable("id") Long id) {
        UserDto u = userService.getById(id);
        logger.debug("User, getById() :{}", u);
        return u;
    }

    /**
     * Endpoint /users type GET
     *
     * @return List<UserDto> of the users contains in database
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAll() {
        List<UserDto> u = userService.getAll();
        logger.debug("User, getAll() :{}", u);
        return u;
    }

    /**
     * Endpoint /users type POST
     *
     * @return UserDto created
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody UserDto userDto) {
        UserDto u = userService.create(userDto);
        logger.debug("User, create() :{}", u);
        return u;
    }

    /**
     * Endpoint /users type PUT
     *
     * @return UserDto updated
     */
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UserDto update(@RequestBody UserDto userDto) {
        UserDto u = userService.update(userDto);
        logger.debug("User, update() :{}", u);
        return u;
    }

    /**
     * Endpoint /users/{id} type DELETE
     *
     * @param id id of the deleted user
     */
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        logger.debug("User, delete() :{}", id);
        userService.deleteById(id);
    }
}
