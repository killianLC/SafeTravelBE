package com.safeTravel.controller;

import com.safeTravel.dto.TripDto;
import com.safeTravel.service.TripService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/trips")
public class TripController {
    private static final Logger logger = LoggerFactory.getLogger(TripController.class);
    @Autowired
    private TripService tripService;

    /**
     * Endpoint /trips/{id} type GET
     *
     * @return TripDto found thanks to his id
     */
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.FOUND)
    public TripDto getById(@PathVariable("id") Long id) {
        TripDto t = tripService.getById(id);
        logger.debug("Trip, getById() :{}", t);
        return t;
    }

    /**
     * Endpoint /trips type GET
     *
     * @return List<TripDto> of the trips contains in database
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TripDto> getAll() {
        List<TripDto> t = tripService.getAll();
        logger.debug("Trip, getAll() :{}", t);
        return t;
    }

    /**
     * Endpoint /trips type POST
     *
     * @return TripDto created
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TripDto create(@RequestBody TripDto tripDto) {
        TripDto t = this.tripService.create(tripDto);
        logger.debug("Trip, create() :{}", t);
        return t;
    }

    /**
     * Endpoint /trips type PUT
     *
     * @return TripDto updated
     */
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public TripDto update(@RequestBody TripDto tripDto) {
        TripDto t = this.tripService.update(tripDto);
        logger.debug("Trip, update() :{}", t);
        return t;
    }

    /**
     * Endpoint /trips/{id} type DELETE
     *
     * @param id id of the deleted trip
     */
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        logger.debug("Trip, delete() :{}", id);
        this.tripService.deleteById(id);
    }
}
