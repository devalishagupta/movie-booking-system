package com.alisha.moviebookingsystem.mapper;

import com.alisha.moviebookingsystem.dto.response.SeatResponse;
import com.alisha.moviebookingsystem.entity.Seat;
import org.springframework.stereotype.Component;

@Component
public class SeatMapper {


    public SeatResponse toResponse(Seat seat) {

        return SeatResponse.builder()
                .id(seat.getId())
                .rowName(seat.getRowName())
                .seatNumber(seat.getSeatNumber())
                .seatType(seat.getSeatType())
                .screenId(seat.getScreen().getId())
                .build();
    }
}