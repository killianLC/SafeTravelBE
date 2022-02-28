package com.safeTravel.service.impl;

import com.safeTravel.dto.RoleDto;
import com.safeTravel.mapper.referentiel.RoleMapper;
import com.safeTravel.repository.RoleRepository;
import com.safeTravel.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleMapper roleMapper;

    /**
     * {@inheritDoc}
     */
    public List<RoleDto> getAll() {
        return this.roleMapper.toDtos(this.roleRepository.findAll());
    }

    /**
     * {@inheritDoc}
     */
    public RoleDto getById(Long id) {
        return this.roleRepository.findById(id).map(roleMapper::toDto).orElseThrow(EntityNotFoundException::new);
    }

    /**
     * {@inheritDoc}
     */
    public RoleDto update(RoleDto roleDto) {
        return this.roleMapper.toDto(this.roleRepository.save(this.roleMapper.toEntity(roleDto)));
    }

    /**
     * {@inheritDoc}
     */
    public RoleDto create(RoleDto roleDto) {
        return this.roleMapper.toDto(this.roleRepository.save(this.roleMapper.toEntity(roleDto)));
    }

    /**
     * {@inheritDoc}
     */
    public void deleteById(Long id) {
        this.roleRepository.deleteById(id);
    }
}
