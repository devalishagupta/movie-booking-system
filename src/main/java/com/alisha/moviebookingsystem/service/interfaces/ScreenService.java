package com.alisha.moviebookingsystem.service.interfaces;

import com.alisha.moviebookingsystem.dto.request.ScreenCreateRequest;
import com.alisha.moviebookingsystem.dto.response.ScreenResponse;

import java.util.List;
import java.util.UUID;

public interface ScreenService {

    ScreenResponse createScreen(ScreenCreateRequest request);

    List<ScreenResponse> getAllScreens();

    List<ScreenResponse> getScreensByTheatre(UUID theatreId);

    ScreenResponse getScreen(UUID id);

    void deleteScreen(UUID id);
}