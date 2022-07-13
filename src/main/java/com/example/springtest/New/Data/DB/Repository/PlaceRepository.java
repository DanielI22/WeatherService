package com.example.springtest.New.Data.DB.Repository;

import com.example.springtest.New.Data.DB.Entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place findByNameAndCountryName(String placeName, String countryName);
}