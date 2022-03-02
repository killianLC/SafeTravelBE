package com.safeTravel.service.impl;

import com.safeTravel.dto.StepDto;
import com.safeTravel.mapper.referentiel.StepMapper;
import com.safeTravel.repository.StepRepository;
import com.safeTravel.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepServiceImpl implements StepService {

    @Autowired
    private StepMapper stepMapper;

    @Autowired
    private StepRepository stepRepository;

    @Override
    public List<StepDto> getAll() {
        return null;
    }

    @Override
    public StepDto getById(Long id) {
        return null;
    }

    @Override
    public StepDto create(StepDto dto) {
        return this.stepMapper.toDto(this.stepRepository.save(this.stepMapper.toEntity(dto)));
    }

    @Override
    public StepDto update(StepDto dto) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
