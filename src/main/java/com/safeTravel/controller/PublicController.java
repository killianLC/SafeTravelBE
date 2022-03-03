package com.safeTravel.controller;

import com.safeTravel.dto.*;
import com.safeTravel.entity.City;
import com.safeTravel.entity.Note;
import com.safeTravel.mapper.referentiel.CityMapper;
import com.safeTravel.repository.CityRepository;
import com.safeTravel.repository.RoleRepository;
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
    CityRepository cityRepository;

    @Autowired
    private CityMapper cityMapper;

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
        City city = new City();
        try {
            return cityService.getByName(name);
        } catch (Exception e) {
            city.setName(name);
            cityRepository.save(city);
        }
        return cityMapper.toDto(city);
    }

    /**
     * Endpoint /city/average/{nom} type GET
     *
     * @return Double
     */
    @GetMapping({"/city/{name}/average"})
    @ResponseStatus(HttpStatus.OK)
    public HashMap getAverageByName(@PathVariable("name") String name) {
        HashMap<String, Object> response = new HashMap<>();

        Double ratingAverage = cityService.getRatingAverageByName(name);
        Double meteoAverage = cityService.getMeteoAverageByName(name);

        response.put("rating_average", ratingAverage);
        response.put("meteo_average", meteoAverage);

        logger.debug("City, getAverageByName() :{}", name);
        return response;
    }

    /**
     * Endpoint /city/notes/{nom} type GET
     *
     * @return Double
     */
    @GetMapping({"/city/{name}/notes"})
    @ResponseStatus(HttpStatus.OK)
    public HashMap getNotesByName(@PathVariable("name") String name) {
        HashMap<String, Object> response = new HashMap<>();

        List<NoteQueryDto> ratings = cityService.getUsersRatingsByName(name);
        List<NoteQueryDto> meteo = cityService.getMeteoRatingsByName(name);

        response.put("ratings", ratings);
        response.put("meteo", meteo);

        logger.debug("City, getAverageByName() :{}", name);
        return response;
    }
}
