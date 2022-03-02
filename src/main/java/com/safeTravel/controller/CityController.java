package com.safeTravel.controller;

import com.safeTravel.dto.CityDto;
import com.safeTravel.dto.ReducedCityDto;
import com.safeTravel.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;

@Slf4j
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
     * Endpoint / type GET
     *
     * @return List<CityDto> of the cities contains in database
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ReducedCityDto> getAll() {
        List<ReducedCityDto> cities = cityService.getAllReducedCity();
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
        try {

        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } catch(Exception e) {
            log.debug(e.getMessage());
        }
        return cityService.getByName(name);
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

        logger.debug("City, getAverageByName() :{}", name);
        return response;
    }

    @PostMapping({"/favoris/{cityId}"})
    @ResponseStatus(HttpStatus.OK)
    public void createFavoris(@RequestHeader("UtilisateurId") Long utilisateurId, @PathVariable("cityId") Long cityId) {
        if(utilisateurId == null) throw new AccessDeniedException("L'utilisateur n'est pas connecté");
        this.cityService.createFavoris(cityId, utilisateurId);
    }

    @DeleteMapping({"/favoris/{cityId}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteFavoris(@RequestHeader("UtilisateurId") Long utilisateurId, @PathVariable("cityId") Long cityId) {
        if(utilisateurId == null) throw new AccessDeniedException("L'utilisateur n'est pas connecté");
        this.cityService.deleteFavoris(cityId, utilisateurId);
    }

    @GetMapping({"/favoris/isFav/{cityId}"})
    @ResponseStatus(HttpStatus.OK)
    public Boolean isFavoris(@RequestHeader("UtilisateurId") Long utilisateurId, @PathVariable("cityId") Long cityId) {
        if(utilisateurId == null) throw new AccessDeniedException("L'utilisateur n'est pas connecté");
        return this.cityService.isFavoris(cityId, utilisateurId);
    }
}
