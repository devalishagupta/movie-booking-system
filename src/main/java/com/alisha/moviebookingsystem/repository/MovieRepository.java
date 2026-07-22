package com.alisha.moviebookingsystem.repository;

import com.alisha.moviebookingsystem.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface MovieRepository extends JpaRepository<Movie, UUID> {


    Optional<Movie> findByTitleIgnoreCase(String title);

}