package com.alisha.moviebookingsystem.controller.admin;

import com.alisha.moviebookingsystem.dto.request.CityCreateRequest;
import com.alisha.moviebookingsystem.dto.response.ApiResponse;
import com.alisha.moviebookingsystem.dto.response.CityResponse;
import com.alisha.moviebookingsystem.service.interfaces.CityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping
    public ResponseEntity<ApiResponse<CityResponse>> createCity(
            @Valid @RequestBody CityCreateRequest request) {

        CityResponse response = cityService.createCity(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(
                        "City created successfully",
                        response
                ));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CityResponse>>> getAllCities() {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Cities fetched successfully",
                        cityService.getAllCities()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CityResponse>> getCity(
            @PathVariable UUID id) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "City fetched successfully",
                        cityService.getCity(id)
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteCity(
            @PathVariable UUID id) {

        cityService.deleteCity(id);

        return ResponseEntity.ok(
                ApiResponse.success(
                        "City deleted successfully",
                        "Success"
                )
        );
    }
}
