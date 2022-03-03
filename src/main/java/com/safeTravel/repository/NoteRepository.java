package com.safeTravel.repository;

import com.safeTravel.entity.City;
import com.safeTravel.entity.Criterion;
import com.safeTravel.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    Optional<Note> findByCriterionAndDateAndCity(Criterion criterion, LocalDate date, City city);
    List<Note> findAllByCriterionAndCity(Criterion criterion, City city);

    @Query(value="SELECT AVG(note.note) AS average_criterion FROM note, criterion, city WHERE criterion.name = :criterionName AND note.criterion_id = criterion.id AND note.city_id = :cityId", nativeQuery = true)
    Double calculateGlobalNoteForCriterion(@Param("criterionName") String criterionName, @Param("cityId") Long cityId);
}
