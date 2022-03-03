package com.safeTravel.repository;

import com.safeTravel.dto.CityClassementDto;
import com.safeTravel.dto.NoteDto;
import com.safeTravel.dto.NoteQueryDto;
import com.safeTravel.entity.City;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findByName(String name);

    @Query(value="SELECT AVG(comment.rating) FROM city, comment WHERE city.name = :name AND city.id = comment.city_id", nativeQuery = true)
    Double getRatingAverageByName(@Param("name") String name);

    @Query(value="SELECT AVG(note.note) FROM city, criterion, note WHERE city.name = :name AND criterion.type = \"METEO_NOTES\" AND note.city_id = city.id AND note.criterion_id = criterion.id", nativeQuery = true)
    Double getMeteoAverageByName(@Param("name") String name);

    @Query(value="SELECT new com.safeTravel.dto.NoteQueryDto(note.id, note.date, note.note) FROM City city, Criterion criterion, Note note WHERE city.name = ?1 AND criterion.type = 'USER_NOTES' AND note.city.id = city.id AND note.criterion.id = criterion.id")
    List<NoteQueryDto> getUsersRatingsByName(@Param("name") String name);

    @Query(value="SELECT new com.safeTravel.dto.NoteQueryDto(note.id, note.date, note.note) FROM City city, Criterion criterion, Note note WHERE city.name = ?1 AND criterion.type = 'METEO_NOTES' AND note.city.id = city.id AND note.criterion.id = criterion.id")
    List<NoteQueryDto> getMeteoRatingsByName(@Param("name") String name);

    @Transactional
    @Query(value = "SELECT new com.safeTravel.dto.CityClassementDto(c.id, c.name, ROUND(AVG(n.note),1) as note) FROM City c, Note n WHERE c.id = n.city.id GROUP BY c.id ORDER BY note DESC")
    List<CityClassementDto> findTop10ByOrderByNotesDesc(PageRequest pageable);
}