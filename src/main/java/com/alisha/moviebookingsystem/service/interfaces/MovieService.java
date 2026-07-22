package com.alisha.moviebookingsystem.service.interfaces;

import com.alisha.moviebookingsystem.dto.request.MovieCreateRequest;
import com.alisha.moviebookingsystem.dto.response.MovieResponse;

import java.util.List;
import java.util.UUID;

public interface MovieService {

    MovieResponse createMovie(MovieCreateRequest request);

    List<MovieResponse> getAllMovies();

    MovieResponse getMovie(UUID id);

    void deleteMovie(UUID id);
}