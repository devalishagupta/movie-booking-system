package com.alisha.moviebookingsystem.controller.admin;

import com.alisha.moviebookingsystem.dto.request.TheatreCreateRequest;
import com.alisha.moviebookingsystem.dto.response.ApiResponse;
import com.alisha.moviebookingsystem.dto.response.TheatreResponse;
import com.alisha.moviebookingsystem.service.interfaces.TheatreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin/theatres")
@RequiredArgsConstructor
public class TheatreController {

    private final TheatreService theatreService;


    @PostMapping
    public ResponseEntity<ApiResponse<TheatreResponse>> createTheatre(
            @Valid @RequestBody TheatreCreateRequest request) {

        TheatreResponse response = theatreService.createTheatre(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.success(
                                "Theatre created successfully",
                                response
                        )
                );
    }


    @GetMapping
    public ResponseEntity<ApiResponse<List<TheatreResponse>>> getAllTheatres() {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Theatres fetched successfully",
                        theatreService.getAllTheatres()
                )
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TheatreResponse>> getTheatre(
            @PathVariable UUID id) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Theatre fetched successfully",
                        theatreService.getTheatre(id)
                )
        );
    }


    @GetMapping("/city/{cityId}")
    public ResponseEntity<ApiResponse<List<TheatreResponse>>> getTheatresByCity(
            @PathVariable UUID cityId) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Theatres fetched successfully for city",
                        theatreService.getTheatresByCity(cityId)
                )
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteTheatre(
            @PathVariable UUID id) {

        theatreService.deleteTheatre(id);

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Theatre deleted successfully",
                        "Success"
                )
        );
    }
}