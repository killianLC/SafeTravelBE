package com.safeTravel.service.impl;

import com.safeTravel.dto.NoteDto;
import com.safeTravel.mapper.referentiel.NoteMapper;
import com.safeTravel.repository.NoteRepository;
import com.safeTravel.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

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
