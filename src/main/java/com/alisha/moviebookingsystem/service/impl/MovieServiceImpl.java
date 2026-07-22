package com.alisha.moviebookingsystem.service.impl;

import com.alisha.moviebookingsystem.dto.request.MovieCreateRequest;
import com.alisha.moviebookingsystem.dto.response.MovieResponse;
import com.alisha.moviebookingsystem.entity.Movie;
import com.alisha.moviebookingsystem.exception.DuplicateResourceException;
import com.alisha.moviebookingsystem.exception.ResourceNotFoundException;
import com.alisha.moviebookingsystem.mapper.MovieMapper;
import com.alisha.moviebookingsystem.repository.MovieRepository;
import com.alisha.moviebookingsystem.service.interfaces.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    private final MovieMapper movieMapper;

    @Override
    public MovieResponse createMovie(MovieCreateRequest request) {

        movieRepository.findByTitleIgnoreCase(request.getTitle())
                .ifPresent(movie -> {
                    throw new DuplicateResourceException(
                            "Movie already exists with title : " + request.getTitle()
                    );
                });

        Movie movie = Movie.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .duration(request.getDuration())
                .language(request.getLanguage())
                .genre(request.getGenre())
                .releaseDate(request.getReleaseDate())
                .build();

        Movie savedMovie = movieRepository.save(movie);

        return movieMapper.toResponse(savedMovie);
    }

    @Override
    public List<MovieResponse> getAllMovies() {

        return movieRepository.findAll()
                .stream()
                .map(movieMapper::toResponse)
                .toList();
    }

    @Override
    public MovieResponse getMovie(UUID id) {

        Movie movie = movieRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Movie not found with id : " + id
                        )
                );

        return movieMapper.toResponse(movie);
    }

    @Override
    public void deleteMovie(UUID id) {

        Movie movie = movieRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Movie not found with id : " + id
                        )
                );

        movieRepository.delete(movie);
    }
}