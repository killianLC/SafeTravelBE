package com.safeTravel.controller;

import com.safeTravel.dto.CityDto;
import com.safeTravel.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/cities"})
public class CityController {
    private static final Logger logger = LoggerFactory.getLogger(CityController.class);

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    /**
     * Endpoint /city/{nom} type GET
     *
     * @return UserDto found thanks to his id
     */
    @GetMapping({"/{name}"})
    @ResponseStatus(HttpStatus.FOUND)
    public CityDto getByName(@PathVariable("name") String name) {
        CityDto cityDto = cityService.getByName(name);
        logger.debug("City, getByName() :{}", name);
        return cityDto;
    }
}
