package com.safeTravel.service.impl;

import com.safeTravel.dto.ParticipantDto;
import com.safeTravel.dto.StepWithoutTripDto;
import com.safeTravel.dto.TripDto;
import com.safeTravel.dto.create.StepCreationDto;
import com.safeTravel.dto.create.TripCreationDto;
import com.safeTravel.entity.*;
import com.safeTravel.mapper.referentiel.ParticipantMapper;
import com.safeTravel.mapper.referentiel.StepWithoutTripMapper;
import com.safeTravel.mapper.referentiel.TripMapper;
import com.safeTravel.repository.*;
import com.safeTravel.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
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
    @Autowired
    private StepServiceImpl stepService;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private StepRepository stepRepository;
    @Autowired
    private StepWithoutTripMapper stepWithoutTripMapper;
    @Autowired
    private ParticipantMapper participantMapper;

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
    public ParticipantDto isParticipant(Long utilisateurId, Long tripId) {
        Optional<User> user = this.userRepository.findById(utilisateurId);
        Optional<Trip> trip = this.tripRepository.findById(tripId);

        if(!user.isPresent() || !trip.isPresent()) throw new EntityNotFoundException("L'utilisateur ou le voyage n'existe pas");

        if(user.get().getId().equals(trip.get().getOrganisateur().getId())) throw new AccessDeniedException("L'organisateur ne peux pas être participant");

        Optional<Participant> participant = this.participantRepository.findByTripAndUser(trip.get(), user.get());

        if(!participant.isPresent()) { throw new EntityNotFoundException("Le participant n'existe pas"); }
        else {
            if(trip.get().getParticipants().contains(participant.get())) return this.participantMapper.toDto(participant.get());
            else throw new AccessDeniedException("L'utilisateur ne participas pas au voyage'");
        }
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

    @Override
    public void deleteStep(Long utilisateurId, Long tripId, Long stepId) {
        Optional<Trip> trip = this.tripRepository.findById(tripId);

        if (!trip.isPresent()) throw new EntityNotFoundException("Le voyage n'existe pas");
        if(!trip.get().getOrganisateur().getId().equals(utilisateurId)) throw new AccessDeniedException("Cet utilisateur n'est pas l'organisateur du voyage");

        Optional<Step> step = trip.get().getSteps().stream().filter((s -> s.getId().equals(stepId))).findFirst();
        if(!step.isPresent()) throw new EntityNotFoundException("L'étape n'existe pas");

        trip.get().getSteps().remove(step.get());

        this.tripRepository.save(trip.get());
        this.stepRepository.deleteById(step.get().getId());
    }

    @Override
    public StepWithoutTripDto createStep(Long utilisateurId, Long tripId, StepCreationDto stepCreationDto) {
        Optional<Trip> trip = this.tripRepository.findById(tripId);

        if (!trip.isPresent()) throw new EntityNotFoundException("Le voyage n'existe pas");
        if(!trip.get().getOrganisateur().getId().equals(utilisateurId)) throw new AccessDeniedException("Cet utilisateur n'est pas l'organisateur du voyage");


        Step newStep = new Step();
        newStep.setTrip(trip.get());
        newStep.setDate(stepCreationDto.getDate());

        Optional<City> city = this.cityRepository.findByName(stepCreationDto.getCityName());
        if(!city.isPresent()) throw new EntityNotFoundException("Une ville pour une des étapes n'existe pas");

        newStep.setCity(city.get());

        return this.stepWithoutTripMapper.toDto(this.stepRepository.save(newStep));
    }

    @Override
    public void modifyDescription(Long utilisateurId, Long tripId, String description) {
        Optional<Trip> trip = this.tripRepository.findById(tripId);

        if (!trip.isPresent()) throw new EntityNotFoundException("Le voyage n'existe pas");
        if(!trip.get().getOrganisateur().getId().equals(utilisateurId)) throw new AccessDeniedException("Cet utilisateur n'est pas l'organisateur du voyage");

        trip.get().setDescription(description);
        this.tripRepository.save(trip.get());
    }

    @Override
    public void deleteTripSecure(Long organisateurIdTrip, Long tripId){
        Optional<Trip> trip = this.tripRepository.findById(tripId);
        if (!trip.isPresent()) throw new EntityNotFoundException("Le voyage n'existe pas");
        if(!trip.get().getOrganisateur().getId().equals(organisateurIdTrip)) throw new AccessDeniedException("Cet utilisateur n'est pas l'organisateur du voyage");
        this.tripRepository.deleteById(tripId);
    }
}
