package com.alisha.moviebookingsystem.repository;

import com.alisha.moviebookingsystem.entity.City;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, UUID> {

    Optional<City> findByNameIgnoreCase(String name);

}
