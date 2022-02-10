package com.safeTravel.service.impl;

import com.safeTravel.dto.UserDto;
import com.safeTravel.mapper.referentiel.UserMapper;
import com.safeTravel.repository.UserRepository;
import com.safeTravel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserDto> getAll() {
        return userMapper.toDtos(userRepository.findAll());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDto getById(Long id) {
        return userRepository.findById(id).map(userMapper::toDto).orElseThrow(EntityNotFoundException::new);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDto create(UserDto dto) {
        return userMapper.toDto(userRepository.save(userMapper.toEntity(dto)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDto update(UserDto dto) {
        return userMapper.toDto(userRepository.save(userMapper.toEntity(dto)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
