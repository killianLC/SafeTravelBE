package com.safeTravel.service.impl;

import com.safeTravel.dto.NoteDto;
import com.safeTravel.entity.City;
import com.safeTravel.entity.Criterion;
import com.safeTravel.entity.Note;
import com.safeTravel.mapper.referentiel.NoteMapper;
import com.safeTravel.repository.NoteRepository;
import com.safeTravel.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private NoteMapper noteMapper;

    /**
     * {@inheritDoc}
     */
    public List<NoteDto> getAll() {
        return this.noteMapper.toDtos(this.noteRepository.findAll());
    }

    /**
     * {@inheritDoc}
     */
    public NoteDto getById(Long id) {
        return this.noteRepository.findById(id).map(noteMapper::toDto).orElseThrow(EntityNotFoundException::new);
    }

    /**
     * {@inheritDoc}
     */
    public NoteDto update(NoteDto noteDto) {
        return this.noteMapper.toDto(this.noteRepository.save(this.noteMapper.toEntity(noteDto)));
    }

    /**
     * {@inheritDoc}
     */
    public NoteDto create(NoteDto noteDto) {
        return this.noteMapper.toDto(this.noteRepository.save(this.noteMapper.toEntity(noteDto)));
    }

    /**
     * {@inheritDoc}
     */
    public void deleteById(Long id) {
        this.noteRepository.deleteById(id);
    }
}
