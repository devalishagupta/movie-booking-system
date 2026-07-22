package com.alisha.moviebookingsystem.entity;

import com.alisha.moviebookingsystem.enums.MovieGenre;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie extends BaseEntity {


    private String title;


    private String description;


    private Integer duration;


    private String language;


    @Enumerated(EnumType.STRING)
    private MovieGenre genre;


    private LocalDate releaseDate;

}