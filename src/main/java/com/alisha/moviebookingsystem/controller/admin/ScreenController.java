package com.alisha.moviebookingsystem.controller.admin;

import com.alisha.moviebookingsystem.dto.request.ScreenCreateRequest;
import com.alisha.moviebookingsystem.dto.response.ApiResponse;
import com.alisha.moviebookingsystem.dto.response.ScreenResponse;
import com.alisha.moviebookingsystem.service.interfaces.ScreenService;
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
public class ScreenController {


    private final ScreenService screenService;


    @PostMapping
    public ResponseEntity<ApiResponse<ScreenResponse>> createScreen(
            @Valid @RequestBody ScreenCreateRequest request) {


        ScreenResponse response = screenService.createScreen(request);


        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.success(
                                "Screen created successfully",
                                response
                        )
                );
    }


    @GetMapping
    public ResponseEntity<ApiResponse<List<ScreenResponse>>> getAllScreens() {


        return ResponseEntity.ok(
                ApiResponse.success(
                        "Screens fetched successfully",
                        screenService.getAllScreens()
                )
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ScreenResponse>> getScreen(
            @PathVariable UUID id) {


        return ResponseEntity.ok(
                ApiResponse.success(
                        "Screen fetched successfully",
                        screenService.getScreen(id)
                )
        );
    }


    @GetMapping("/theatre/{theatreId}")
    public ResponseEntity<ApiResponse<List<ScreenResponse>>> getScreensByTheatre(
            @PathVariable UUID theatreId) {


        return ResponseEntity.ok(
                ApiResponse.success(
                        "Screens fetched successfully for theatre",
                        screenService.getScreensByTheatre(theatreId)
                )
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteScreen(
            @PathVariable UUID id) {


        screenService.deleteScreen(id);


        return ResponseEntity.ok(
                ApiResponse.success(
                        "Screen deleted successfully",
                        "Success"
                )
        );
    }
}