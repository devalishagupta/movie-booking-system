package com.alisha.moviebookingsystem.repository;

import com.alisha.moviebookingsystem.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TheatreRepository extends JpaRepository<Theatre, UUID> {

    List<Theatre> findByCityId(UUID cityId);

}