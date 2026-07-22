package com.alisha.moviebookingsystem.entity;

import com.alisha.moviebookingsystem.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "seats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat extends BaseEntity {


    private String rowName;


    private Integer seatNumber;


    @Enumerated(EnumType.STRING)
    private SeatType seatType;


    @ManyToOne
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;

}