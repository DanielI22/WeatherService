package com.example.springtest.data.db.Repository;

import com.example.springtest.data.db.Entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place findByNameAndCountryName(String placeName, String countryName);
}