package com.alisha.moviebookingsystem.dto.request;

import com.alisha.moviebookingsystem.enums.SeatType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RowConfiguration {

    @NotBlank
    private String rowName;

    @NotNull
    @Positive
    private Integer numberOfSeats;

    @NotNull
    private SeatType seatType;
}