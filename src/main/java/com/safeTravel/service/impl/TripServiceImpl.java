package com.safeTravel.service.impl;

import com.safeTravel.dto.TripDto;
import com.safeTravel.dto.create.TripCreationDto;
import com.safeTravel.entity.*;
import com.safeTravel.mapper.referentiel.TripMapper;
import com.safeTravel.repository.CityRepository;
import com.safeTravel.repository.ParticipantRepository;
import com.safeTravel.repository.TripRepository;
import com.safeTravel.repository.UserRepository;
import com.safeTravel.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private TripMapper tripMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StepServiceImpl stepService;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private ParticipantRepository participantRepository;

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

    @Override
    public TripDto create(TripDto dto) {
        return null;
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
    public Long create(TripCreationDto tripDto) {
        Optional<User> user = this.userRepository.findById(tripDto.getOrganisateurId());

        if(!user.isPresent()) throw new EntityNotFoundException("L'organisateur de ce trip n'existe pas");

        Trip trip = new Trip();
        trip.setDescription(tripDto.getDescription());
        trip.setOrganisateur(user.get());
        trip.setSteps(new HashSet<>());

        tripDto.getSteps().forEach((step) -> {
            Step newStep = new Step();
            newStep.setTrip(trip);
            newStep.setDate(step.getDate());

            Optional<City> city = this.cityRepository.findByName(step.getCityName());
            if(!city.isPresent()) throw new EntityNotFoundException("Une ville pour une des étapes n'existe pas");

            newStep.setCity(city.get());
            trip.getSteps().add(newStep);
        });

        this.tripRepository.save(trip);

        return trip.getId();
    }

    @Override
    public Boolean isParticipant(Long utilisateurId, Long tripId) {
        Optional<User> user = this.userRepository.findById(utilisateurId);
        Optional<Trip> trip = this.tripRepository.findById(tripId);

        if(!user.isPresent() || !trip.isPresent()) throw new EntityNotFoundException("L'utilisateur ou le voyage n'existe pas");

        if(user.get().getId().equals(trip.get().getOrganisateur().getId())) throw new EntityExistsException("L'organisateur ne peux pas rejoindre le voyage");

        Optional<Participant> participant = this.participantRepository.findByTripAndUser(trip.get(), user.get());

        if(!participant.isPresent()) { return false; }
        else return trip.get().getParticipants().contains(participant.get());
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
