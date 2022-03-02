package com.safeTravel.controller;

import com.safeTravel.dto.CityClassementDto;
import com.safeTravel.dto.ReducedCityDto;
import com.safeTravel.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/public"})
public class PublicController {

    private static final Logger logger = LoggerFactory.getLogger(PublicController.class);

    @Autowired
    private CityService cityService;

    @GetMapping({"/top10"})
    @ResponseStatus(HttpStatus.OK)
    public List<CityClassementDto> getTop10OrderByDesc() {
        return cityService.getTop10ByNotesDesc();
    }

    /**
     * Endpoint /cities type GET
     *
     * @return List<CityDto> of the cities contains in database
     */
    @GetMapping({"/cities"})
    @ResponseStatus(HttpStatus.OK)
    public List<ReducedCityDto> getAll() {
        List<ReducedCityDto> cities = cityService.getAllReducedCity();
        logger.info("City, getAll() :{}", cities);
        return cities;
    }
}
