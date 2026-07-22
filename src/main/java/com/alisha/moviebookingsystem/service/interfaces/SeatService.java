package com.alisha.moviebookingsystem.service.interfaces;

import com.alisha.moviebookingsystem.dto.request.SeatLayoutRequest;
import com.alisha.moviebookingsystem.dto.response.SeatResponse;

import java.util.List;
import java.util.UUID;

public interface SeatService {

    List<SeatResponse> createSeatLayout(
            UUID screenId,
            SeatLayoutRequest request
    );

    List<SeatResponse> getSeatsByScreen(UUID screenId);
}