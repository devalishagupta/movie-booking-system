package com.alisha.moviebookingsystem.service.impl;

import com.alisha.moviebookingsystem.dto.request.ScreenCreateRequest;
import com.alisha.moviebookingsystem.dto.response.ScreenResponse;
import com.alisha.moviebookingsystem.entity.Screen;
import com.alisha.moviebookingsystem.entity.Theatre;
import com.alisha.moviebookingsystem.exception.ResourceNotFoundException;
import com.alisha.moviebookingsystem.mapper.ScreenMapper;
import com.alisha.moviebookingsystem.repository.ScreenRepository;
import com.alisha.moviebookingsystem.repository.TheatreRepository;
import com.alisha.moviebookingsystem.service.interfaces.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ScreenServiceImpl implements ScreenService {


    private final ScreenRepository screenRepository;

    private final TheatreRepository theatreRepository;

    private final ScreenMapper screenMapper;


    @Override
    public ScreenResponse createScreen(ScreenCreateRequest request) {


        Theatre theatre = theatreRepository.findById(request.getTheatreId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Theatre not found with id : "
                                        + request.getTheatreId()
                        )
                );


        Screen screen = Screen.builder()
                .name(request.getName())
                .screenNumber(request.getScreenNumber())
                .theatre(theatre)
                .build();


        Screen savedScreen = screenRepository.save(screen);


        return screenMapper.toResponse(savedScreen);
    }


    @Override
    public List<ScreenResponse> getAllScreens() {

        return screenRepository.findAll()
                .stream()
                .map(screenMapper::toResponse)
                .toList();
    }


    @Override
    public List<ScreenResponse> getScreensByTheatre(UUID theatreId) {

        return screenRepository.findByTheatreId(theatreId)
                .stream()
                .map(screenMapper::toResponse)
                .toList();
    }


    @Override
    public ScreenResponse getScreen(UUID id) {


        Screen screen = screenRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Screen not found with id : " + id
                        )
                );


        return screenMapper.toResponse(screen);
    }


    @Override
    public void deleteScreen(UUID id) {


        Screen screen = screenRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Screen not found with id : " + id
                        )
                );


        screenRepository.delete(screen);
    }
}