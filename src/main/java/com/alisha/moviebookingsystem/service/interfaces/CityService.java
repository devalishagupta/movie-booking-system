package com.alisha.moviebookingsystem.service.interfaces;

import com.alisha.moviebookingsystem.dto.request.CityCreateRequest;
import com.alisha.moviebookingsystem.dto.response.CityResponse;
import com.alisha.moviebookingsystem.exception.DuplicateResourceException;
import java.util.UUID;

import java.util.List;

public interface CityService {
    CityResponse createCity(CityCreateRequest request) throws DuplicateResourceException;

    List<CityResponse> getAllCities();

    CityResponse getCity(UUID id);

    void deleteCity(UUID id);
}
