package com.alisha.moviebookingsystem.dto.response;

import com.alisha.moviebookingsystem.enums.SeatType;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class SeatResponse {

    private UUID id;

    private String rowName;

    private Integer seatNumber;

    private SeatType seatType;

    private UUID screenId;
}