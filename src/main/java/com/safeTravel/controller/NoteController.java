package com.safeTravel.controller;

import com.safeTravel.dto.NoteDto;
import com.safeTravel.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/notes")
public class NoteController {
    private static final Logger logger = LoggerFactory.getLogger(NoteController.class);

    @Autowired
    private NoteService noteService;

    /**
     * Endpoint /notes/{id} type GET
     *
     * @return NoteDto found thanks to his id
     */
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public NoteDto getById(@PathVariable("id") Long id) {
        NoteDto n = noteService.getById(id);
        logger.debug("Note, getById() :{}", n);
        return n;
    }

    /**
     * Endpoint /notes type GET
     *
     * @return List<NoteDto> of the notes contains in database
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<NoteDto> getAll() {
        List<NoteDto> n = noteService.getAll();
        logger.debug("Note, getAll() :{}", n);
        return n;
    }

    /**
     * Endpoint /notes type POST
     *
     * @return NoteDto created
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NoteDto create(@RequestBody NoteDto noteDto) {
        NoteDto n = this.noteService.create(noteDto);
        logger.debug("Note, create() :{}", n);
        return n;
    }

    /**
     * Endpoint /notes type PUT
     *
     * @return NoteDto updated
     */
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public NoteDto update(@RequestBody NoteDto noteDto) {
        NoteDto n = this.noteService.update(noteDto);
        logger.debug("Note, update() :{}", n);
        return n;
    }

    /**
     * Endpoint /notes/{id} type DELETE
     *
     * @param id id of the deleted note
     */
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        logger.debug("Note, delete() :{}", id);
        this.noteService.deleteById(id);
    }
}
