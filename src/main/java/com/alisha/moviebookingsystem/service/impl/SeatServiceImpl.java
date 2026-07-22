package com.alisha.moviebookingsystem.service.impl;

import com.alisha.moviebookingsystem.dto.request.RowConfiguration;
import com.alisha.moviebookingsystem.dto.request.SeatLayoutRequest;
import com.alisha.moviebookingsystem.dto.response.SeatResponse;
import com.alisha.moviebookingsystem.entity.Screen;
import com.alisha.moviebookingsystem.entity.Seat;
import com.alisha.moviebookingsystem.exception.DuplicateResourceException;
import com.alisha.moviebookingsystem.exception.ResourceNotFoundException;
import com.alisha.moviebookingsystem.mapper.SeatMapper;
import com.alisha.moviebookingsystem.repository.ScreenRepository;
import com.alisha.moviebookingsystem.repository.SeatRepository;
import com.alisha.moviebookingsystem.service.interfaces.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {


    private final SeatRepository seatRepository;

    private final ScreenRepository screenRepository;

    private final SeatMapper seatMapper;


    @Override
    public List<SeatResponse> createSeatLayout(
            UUID screenId,
            SeatLayoutRequest request) {


        Screen screen = screenRepository.findById(screenId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Screen not found with id : " + screenId
                        )
                );


        // Prevent creating duplicate seat layout
        if (!seatRepository.findByScreenId(screenId).isEmpty()) {

            throw new DuplicateResourceException(
                    "Seat layout already exists for screen : " + screenId
            );
        }


        List<Seat> seats = new ArrayList<>();


        for (RowConfiguration row : request.getRows()) {


            for (int seatNumber = 1;
                 seatNumber <= row.getNumberOfSeats();
                 seatNumber++) {


                Seat seat = Seat.builder()
                        .rowName(row.getRowName())
                        .seatNumber(seatNumber)
                        .seatType(row.getSeatType())
                        .screen(screen)
                        .build();


                seats.add(seat);
            }
        }


        List<Seat> savedSeats = seatRepository.saveAll(seats);


        return savedSeats.stream()
                .map(seatMapper::toResponse)
                .toList();
    }


    @Override
    public List<SeatResponse> getSeatsByScreen(UUID screenId) {


        // Validate screen exists
        screenRepository.findById(screenId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Screen not found with id : " + screenId
                        )
                );


        return seatRepository.findByScreenId(screenId)
                .stream()
                .map(seatMapper::toResponse)
                .toList();
    }
}