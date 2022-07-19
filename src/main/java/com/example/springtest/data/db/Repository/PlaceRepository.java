package com.example.springtest.data.db.Repository;

import com.example.springtest.data.db.Entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place findByNameAndCountryName(String placeName, String countryName);

    @Query("FROM Place p WHERE p.name LIKE :name%")
    List<Place> findAllByName(@Param("name") String placeName);
}