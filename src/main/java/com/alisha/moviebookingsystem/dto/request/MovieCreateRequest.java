package com.alisha.moviebookingsystem.dto.request;

import com.alisha.moviebookingsystem.enums.MovieGenre;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MovieCreateRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    @Min(1)
    private Integer duration;

    @NotBlank
    private String language;

    @NotNull
    private MovieGenre genre;

    @NotNull
    private LocalDate releaseDate;
}