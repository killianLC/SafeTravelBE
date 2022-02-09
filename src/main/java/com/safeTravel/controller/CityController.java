package com.safeTravel.controller;

import com.safeTravel.dto.CityDto;
import com.safeTravel.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping({"/city"})
public class CityController {
    private static final Logger logger = LoggerFactory.getLogger(CityController.class);

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    /**
     * Endpoint / type GET
     *
     * @return List<CityDto> of the cities contains in database
     */
    @GetMapping({"/cities"})
    @ResponseStatus(HttpStatus.OK)
    public List<CityDto> getAll() {
        List<CityDto> cities = cityService.getAll();
        logger.info("City, getAll() :{}", cities);
        return cities;
    }

    /**
     * Endpoint /city/{nom} type GET
     *
     * @return UserDto found thanks to his id
     */
    @GetMapping({"/{name}"})
    @ResponseStatus(HttpStatus.OK)
    public CityDto getByName(@PathVariable("name") String name) {
        CityDto cityDto = cityService.getByName(name);
        logger.debug("City, getByName() :{}", name);
        return cityDto;
    }

    /**
     * Endpoint /city/rating_average/{nom} type GET
     *
     * @return Double
     */
    @GetMapping({"/average/{name}"})
    @ResponseStatus(HttpStatus.OK)
    public HashMap getAverageByName(@PathVariable("name") String name) {
        HashMap<String, Object> response = new HashMap<>();

        Double ratingAverage = cityService.getRatingAverageByName(name);

        response.put("rating_average", ratingAverage);
        // TODO à modifier avec les statistiques
        response.put("statistic_average", 0);

        logger.debug("City, getAverageByName() :{}", name);
        return response;
    }
}
