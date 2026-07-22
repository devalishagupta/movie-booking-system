package com.alisha.moviebookingsystem.dto.response;

import com.alisha.moviebookingsystem.enums.MovieGenre;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
public class MovieResponse {

    private UUID id;

    private String title;

    private String description;

    private Integer duration;

    private String language;

    private MovieGenre genre;

    private LocalDate releaseDate;
}