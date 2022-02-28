package com.safeTravel.controller;

import com.safeTravel.dto.RoleDto;
import com.safeTravel.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/roles")
public class RoleController {
    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    private RoleService roleService;

    /**
     * Endpoint /roles/{id} type GET
     *
     * @return RoleDto found thanks to his id
     */
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.FOUND)
    public RoleDto getById(@PathVariable("id") Long id) {
        RoleDto r = roleService.getById(id);
        logger.debug("Role, getById() :{}", r);
        return r;
    }

    /**
     * Endpoint /roles type GET
     *
     * @return List<RoleDto> of the roles contains in database
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RoleDto> getAll() {
        List<RoleDto> r = roleService.getAll();
        logger.debug("Role, getAll() :{}", r);
        return r;
    }

    /**
     * Endpoint /roles type POST
     *
     * @return RoleDto created
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoleDto create(@RequestBody RoleDto roleDto) {
        RoleDto r = this.roleService.create(roleDto);
        logger.debug("Role, create() :{}", r);
        return r;
    }

    /**
     * Endpoint /roles type PUT
     *
     * @return RoleDto updated
     */
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public RoleDto update(@RequestBody RoleDto roleDto) {
        RoleDto r = this.roleService.update(roleDto);
        logger.debug("Role, update() :{}", r);
        return r;
    }

    /**
     * Endpoint /roles/{id} type DELETE
     *
     * @param id id of the deleted role
     */
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        logger.debug("Role, delete() :{}", id);
        this.roleService.deleteById(id);
    }
}
