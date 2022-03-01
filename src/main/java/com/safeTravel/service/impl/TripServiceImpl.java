package com.safeTravel.service.impl;

import com.safeTravel.dto.TripDto;
import com.safeTravel.entity.User;
import com.safeTravel.mapper.referentiel.TripMapper;
import com.safeTravel.repository.TripRepository;
import com.safeTravel.repository.UserRepository;
import com.safeTravel.service.TripService;
import com.safeTravel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private TripMapper tripMapper;
    @Autowired
    private UserRepository userRepository;

    /**
     * {@inheritDoc}
     */
    public List<TripDto> getAll() {
        return this.tripMapper.toDtos(this.tripRepository.findAll());
    }

    /**
     * {@inheritDoc}
     */
    public TripDto getById(Long id) {
        return this.tripRepository.findById(id).map(tripMapper::toDto).orElseThrow(EntityNotFoundException::new);
    }

    /**
     * {@inheritDoc}
     */
    public TripDto update(TripDto tripDto) {
        return this.tripMapper.toDto(this.tripRepository.save(this.tripMapper.toEntity(tripDto)));
    }

    /**
     * {@inheritDoc}
     */
    public TripDto create(TripDto tripDto) {
        //Optional<User> user = this.userRepository.findById(tripDto.getOrganisateurUid());

        //if(user.isPresent())
        return this.tripMapper.toDto(this.tripRepository.save(this.tripMapper.toEntity(tripDto)));
    }

    /**
     * {@inheritDoc}
     */
    public void deleteById(Long id) {
        this.tripRepository.deleteById(id);
    }

    @Override
    public List<TripDto> getUserTrips(Long userId) {
        return this.tripMapper.toDtos(this.tripRepository.findAllByOrganisateurId(userId));
    }
}
