package com.safeTravel.service.impl;

import com.safeTravel.dto.ParticipantDto;
import com.safeTravel.dto.create.ParticipantCreationDto;
import com.safeTravel.dto.delete.ParticipantDeleteDto;
import com.safeTravel.dto.update.ParticipantUpdateDto;
import com.safeTravel.entity.Participant;
import com.safeTravel.entity.Trip;
import com.safeTravel.entity.User;
import com.safeTravel.mapper.referentiel.ParticipantMapper;
import com.safeTravel.repository.ParticipantRepository;
import com.safeTravel.repository.TripRepository;
import com.safeTravel.repository.UserRepository;
import com.safeTravel.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private ParticipantMapper participantMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TripRepository tripRepository;

    @Override
    public List<ParticipantDto> getAll() {
        return this.participantMapper.toDtos(this.participantRepository.findAll());
    }

    @Override
    public ParticipantDto getById(Long id) {
        return this.participantMapper.toDto(this.participantRepository.getById(id));
    }

    @Override
    public ParticipantDto create(ParticipantDto dto) {
        return null;
    }

    public void create(ParticipantCreationDto dto) {
        Optional<Trip> tripOptional = this.tripRepository.findById(dto.getTripId());
        Optional<User> userOptional = this.userRepository.findById(dto.getUserId());

        if(!tripOptional.isPresent() && !userOptional.isPresent())
            throw new EntityNotFoundException("L'utilisateur ou le voyage n'existe pas");

        if(tripOptional.get().getOrganisateur().getId().equals(userOptional.get().getId()))
            throw new AccessDeniedException("L'organisateur du voyage ne peux pas y participer");

        Participant participant = this.participantRepository.findByTripAndUser(tripOptional.get(), userOptional.get()).orElseGet(() -> {
            Participant newParticipant = new Participant();
            newParticipant.setTrip(tripOptional.get());
            newParticipant.setUser(userOptional.get());
            return newParticipant;
        });

        this.participantRepository.save(participant);
    }

    @Override
    public ParticipantDto update(ParticipantDto dto) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void acceptParticipant(ParticipantUpdateDto participantUpdateDto) {
        Optional<Participant> participantOptional = this.participantRepository.findById(participantUpdateDto.getParticipantId());
        Optional<Trip> tripOptional = this.tripRepository.findById(participantUpdateDto.getTripId());

        if(!tripOptional.isPresent() || !participantOptional.isPresent()) throw new EntityNotFoundException("L'utilisateur ou le voyage n'existe pas");

        if(!participantOptional.get().getTrip().getId().equals(tripOptional.get().getId())) throw new AccessDeniedException("Ce participant ne participe pas au trip indiqué");

        participantOptional.get().setStatut(true);
        this.participantRepository.save(participantOptional.get());
    }

    @Override
    public List<ParticipantDto> getAllForTrip(Long tripId) {
        Optional<Trip> tripOptional = this.tripRepository.findById(tripId);

        if(!tripOptional.isPresent()) throw new EntityNotFoundException("Le voyage n'existe pas");

        return this.participantMapper.toDtos(this.participantRepository.findAllByTrip(tripOptional.get()));
    }

    @Override
    public void deleteByIdForATrip(ParticipantDeleteDto participantDeleteDto) {
        Optional<Participant> participantOptional = this.participantRepository.findById(participantDeleteDto.getParticipantId());
        Optional<Trip> tripOptional = this.tripRepository.findById(participantDeleteDto.getTripId());

        if(!tripOptional.isPresent() && !participantOptional.isPresent()) throw new EntityNotFoundException("L'utilisateur ou le voyage n'existe pas");

        if(!participantOptional.get().getTrip().getId().equals(tripOptional.get().getId())) throw new AccessDeniedException("Ce participant ne participe pas au trip indiqué");

        this.participantRepository.deleteById(participantOptional.get().getId());
    }
}
