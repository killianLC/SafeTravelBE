package com.safeTravel.service.impl;

import com.safeTravel.dto.TripDto;
import com.safeTravel.dto.tripsDto.TripCreationDto;
import com.safeTravel.entity.City;
import com.safeTravel.entity.Step;
import com.safeTravel.entity.Trip;
import com.safeTravel.entity.User;
import com.safeTravel.mapper.referentiel.CityMapper;
import com.safeTravel.mapper.referentiel.TripMapper;
import com.safeTravel.repository.CityRepository;
import com.safeTravel.repository.TripRepository;
import com.safeTravel.repository.UserRepository;
import com.safeTravel.service.StepService;
import com.safeTravel.service.TripService;
import com.safeTravel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void create(TripCreationDto tripDto) {
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

        //return this.tripMapper.toDto(trip);
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
