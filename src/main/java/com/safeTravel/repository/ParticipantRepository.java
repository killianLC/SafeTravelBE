package com.safeTravel.repository;

import com.safeTravel.entity.Participant;
import com.safeTravel.entity.Trip;
import com.safeTravel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Optional<Participant> findByTripAndUser(Trip trip, User user);
    List<Participant> findAllByTrip(Trip trip);
}
