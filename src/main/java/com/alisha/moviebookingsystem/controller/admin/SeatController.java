package com.alisha.moviebookingsystem.controller.admin;

import com.alisha.moviebookingsystem.dto.request.SeatLayoutRequest;
import com.alisha.moviebookingsystem.dto.response.ApiResponse;
import com.alisha.moviebookingsystem.dto.response.SeatResponse;
import com.alisha.moviebookingsystem.service.interfaces.SeatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/admin/screens")
@RequiredArgsConstructor
public class SeatController {


    private final SeatService seatService;


    @PostMapping("/{screenId}/seats")
    public ResponseEntity<ApiResponse<List<SeatResponse>>> createSeatLayout(
            @PathVariable UUID screenId,
            @Valid @RequestBody SeatLayoutRequest request) {


        List<SeatResponse> response =
                seatService.createSeatLayout(screenId, request);


        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.success(
                                "Seats created successfully",
                                response
                        )
                );
    }


    @GetMapping("/{screenId}/seats")
    public ResponseEntity<ApiResponse<List<SeatResponse>>> getSeats(
            @PathVariable UUID screenId) {


        return ResponseEntity.ok(
                ApiResponse.success(
                        "Seats fetched successfully",
                        seatService.getSeatsByScreen(screenId)
                )
        );
    }
}