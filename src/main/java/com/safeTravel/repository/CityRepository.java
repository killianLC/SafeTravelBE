package com.safeTravel.repository;

import com.safeTravel.dto.CityClassementDto;
import com.safeTravel.dto.CityDto;
import com.safeTravel.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findByName(String name);

    @Query(value="SELECT AVG(comment.rating) FROM city, comment WHERE city.name = :name AND city.id = comment.city_id", nativeQuery = true)
    Double getRatingAverageByName(@Param("name") String name);
}