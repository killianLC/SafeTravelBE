package com.safeTravel.controller;

import com.safeTravel.dto.CityClassementDto;
import com.safeTravel.dto.CityDto;
import com.safeTravel.dto.ReducedCityDto;
import com.safeTravel.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;

@Slf4j
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

    /**
     * Endpoint /cities/{nom} type GET
     *
     * @return CityDto found thanks to his id
     */
    @GetMapping({"/city/{name}"})
    @ResponseStatus(HttpStatus.OK)
    public CityDto getByName(@PathVariable("name") String name) {
        CityDto city = new CityDto();
        try {
            city = cityService.getByName(name);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
        return city;
    }

    /**
     * Endpoint /city/average/{nom} type GET
     *
     * @return Double
     */
    @GetMapping({"/city/average/{name}"})
    @ResponseStatus(HttpStatus.OK)
    public HashMap getAverageByName(@PathVariable("name") String name) {
        HashMap<String, Object> response = new HashMap<>();

        Double ratingAverage = cityService.getRatingAverageByName(name);

        response.put("rating_average", ratingAverage);

        logger.debug("City, getAverageByName() :{}", name);
        return response;
    }
}
