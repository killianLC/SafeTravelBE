package com.safeTravel.controller;

import com.safeTravel.dto.NoteDto;
import com.safeTravel.dto.ParticipantDto;
import com.safeTravel.dto.create.ParticipantCreationDto;
import com.safeTravel.dto.delete.ParticipantDeleteDto;
import com.safeTravel.dto.update.ParticipantUpdateDto;
import com.safeTravel.service.impl.ParticipantServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/participants")
public class ParticipantController {

    @Autowired
    private ParticipantServiceImpl participantService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ParticipantCreationDto participantCreationDto) {
        this.participantService.create(participantCreationDto);
    }

    @GetMapping("/{tripId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ParticipantDto> getAllForTrip(@PathVariable Long tripId) {
        return this.participantService.getAllForTrip(tripId);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestBody ParticipantDeleteDto participantDeleteDto) {
        this.participantService.deleteByIdForATrip(participantDeleteDto);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void acceptParticipant(@RequestBody ParticipantUpdateDto participantUpdateDto) {
        this.participantService.acceptParticipant(participantUpdateDto);
    }

}
