package com.safeTravel.repository;

import com.safeTravel.dto.TripQueryDto;
import com.safeTravel.entity.Participant;
import com.safeTravel.entity.Trip;
import com.safeTravel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Optional<Participant> findByTripAndUser(Trip trip, User user);
    List<Participant> findAllByTrip(Trip trip);

    @Transactional
    @Query(value="SELECT new com.safeTravel.dto.TripQueryDto(trip.id, trip.description) FROM User user, Trip trip, Participant participant WHERE user.id = :userUid AND user.id = participant.user.id AND trip.organisateur.id != :userUid")
    List<TripQueryDto> getTripsByUserId(@Param("userUid") Long userUid);
}
