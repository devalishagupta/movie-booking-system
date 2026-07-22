package com.alisha.moviebookingsystem.repository;

import com.alisha.moviebookingsystem.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface ScreenRepository
        extends JpaRepository<Screen, UUID> {


    List<Screen> findByTheatreId(UUID theatreId);

}