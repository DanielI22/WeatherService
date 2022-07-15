package com.example.springtest.data.db.Repository;

import com.example.springtest.data.db.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
    boolean existsByName(String name);
    Country findByName(String name);
}
