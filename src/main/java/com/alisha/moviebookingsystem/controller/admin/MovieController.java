package com.alisha.moviebookingsystem.controller.admin;

import com.alisha.moviebookingsystem.dto.request.MovieCreateRequest;
import com.alisha.moviebookingsystem.dto.response.ApiResponse;
import com.alisha.moviebookingsystem.dto.response.MovieResponse;
import com.alisha.moviebookingsystem.service.interfaces.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<ApiResponse<MovieResponse>> createMovie(
            @Valid @RequestBody MovieCreateRequest request) {

        MovieResponse response = movieService.createMovie(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(
                        "Movie created successfully",
                        response
                ));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<MovieResponse>>> getAllMovies() {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Movies fetched successfully",
                        movieService.getAllMovies()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<MovieResponse>> getMovie(
            @PathVariable UUID id) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Movie fetched successfully",
                        movieService.getMovie(id)
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteMovie(
            @PathVariable UUID id) {

        movieService.deleteMovie(id);

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Movie deleted successfully",
                        "Success"
                )
        );
    }
}