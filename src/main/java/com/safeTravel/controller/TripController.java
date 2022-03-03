package com.safeTravel.controller;

import com.safeTravel.dto.StepWithoutTripDto;
import com.safeTravel.dto.TripDto;
import com.safeTravel.dto.create.StepCreationDto;
import com.safeTravel.dto.create.TripCreationDto;
import com.safeTravel.dto.update.TripUpdateDescriptionDto;
import com.safeTravel.service.TripService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
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
    @ResponseStatus(HttpStatus.OK)
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

    @GetMapping({"/user"})
    @ResponseStatus(HttpStatus.OK)
    public List<TripDto> getUserTrips(@RequestHeader("UtilisateurId") Long utilisateurId) {
        if(utilisateurId == null) throw new AccessDeniedException("L'utilisateur n'est pas connecté");
        return this.tripService.getUserTrips(utilisateurId);
    }

    /**
     * Endpoint /trips type POST
     *
     * @return TripDto created
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody TripCreationDto tripDto) {
        return this.tripService.create(tripDto);
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

    @PostMapping("/{tripId}/step/delete/{stepId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStep(@RequestHeader("UtilisateurId") Long utilisateurId, @PathVariable Long tripId, @PathVariable Long stepId) {
        this.tripService.deleteStep(utilisateurId, tripId, stepId);
    }

    @PostMapping("/{tripId}/step/create")
    @ResponseStatus(HttpStatus.OK)
    public StepWithoutTripDto createStep(@RequestHeader("UtilisateurId") Long utilisateurId, @PathVariable Long tripId, @RequestBody StepCreationDto stepCreationDto) {
        return this.tripService.createStep(utilisateurId, tripId, stepCreationDto);
    }

    @PostMapping("/{tripId}/description")
    @ResponseStatus(HttpStatus.OK)
    public void modifyDescription(@RequestHeader("UtilisateurId") Long utilisateurId, @PathVariable Long tripId, @RequestBody TripUpdateDescriptionDto tripUpdateDescriptionDto) {
        this.tripService.modifyDescription(utilisateurId, tripId, tripUpdateDescriptionDto.getDescription());
    }

    /**
     * Endpoint /trips/{id} type DELETE
     *
     * @param id id of the deleted trip
     */
    @PostMapping({"/delete/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestHeader("UtilisateurId") Long utilisateurId,@PathVariable("id") Long id) {
        logger.debug("Trip, delete() :{},{}",utilisateurId, id);
        this.tripService.deleteTripSecure(utilisateurId,id);
    }

    @GetMapping({"/isParticipant/{tripId}"})
    @ResponseStatus(HttpStatus.OK)
    public Boolean isParticipant(@RequestHeader("UtilisateurId") Long utilisateurId, @PathVariable("tripId") Long tripId) {
        if(utilisateurId == null) throw new AccessDeniedException("L'utilisateur n'est pas connecté");
        return this.tripService.isParticipant(utilisateurId, tripId);
    }
}
