package com.safeTravel.service;

import com.safeTravel.dto.NoteDto;
import com.safeTravel.entity.City;

public interface NoteService extends ServiceShared<NoteDto, Long> {
    void addMeteoNote(City city, double note);
}
