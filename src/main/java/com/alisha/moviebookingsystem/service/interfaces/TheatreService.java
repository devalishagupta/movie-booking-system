package com.alisha.moviebookingsystem.service.interfaces;

import com.alisha.moviebookingsystem.dto.request.TheatreCreateRequest;
import com.alisha.moviebookingsystem.dto.response.TheatreResponse;

import java.util.List;
import java.util.UUID;

public interface TheatreService {

    TheatreResponse createTheatre(TheatreCreateRequest request);

    List<TheatreResponse> getAllTheatres();

    List<TheatreResponse> getTheatresByCity(UUID cityId);

    TheatreResponse getTheatre(UUID id);

    void deleteTheatre(UUID id);
}