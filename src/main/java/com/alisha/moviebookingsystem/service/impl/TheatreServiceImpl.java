package com.alisha.moviebookingsystem.service.impl;

import com.alisha.moviebookingsystem.dto.request.TheatreCreateRequest;
import com.alisha.moviebookingsystem.dto.response.TheatreResponse;
import com.alisha.moviebookingsystem.entity.City;
import com.alisha.moviebookingsystem.entity.Theatre;
import com.alisha.moviebookingsystem.exception.ResourceNotFoundException;
import com.alisha.moviebookingsystem.mapper.TheatreMapper;
import com.alisha.moviebookingsystem.repository.CityRepository;
import com.alisha.moviebookingsystem.repository.TheatreRepository;
import com.alisha.moviebookingsystem.service.interfaces.TheatreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TheatreServiceImpl implements TheatreService {


    private final TheatreRepository theatreRepository;

    private final CityRepository cityRepository;

    private final TheatreMapper theatreMapper;


    @Override
    public TheatreResponse createTheatre(TheatreCreateRequest request) {

        City city = cityRepository.findById(request.getCityId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "City not found with id : " + request.getCityId()
                        )
                );


        Theatre theatre = Theatre.builder()
                .name(request.getName())
                .address(request.getAddress())
                .city(city)
                .build();


        Theatre savedTheatre = theatreRepository.save(theatre);

        return theatreMapper.toResponse(savedTheatre);
    }


    @Override
    public List<TheatreResponse> getAllTheatres() {

        return theatreRepository.findAll()
                .stream()
                .map(theatreMapper::toResponse)
                .toList();
    }


    @Override
    public List<TheatreResponse> getTheatresByCity(UUID cityId) {

        return theatreRepository.findByCityId(cityId)
                .stream()
                .map(theatreMapper::toResponse)
                .toList();
    }


    @Override
    public TheatreResponse getTheatre(UUID id) {

        Theatre theatre = theatreRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Theatre not found with id : " + id
                        )
                );

        return theatreMapper.toResponse(theatre);
    }


    @Override
    public void deleteTheatre(UUID id) {

        Theatre theatre = theatreRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Theatre not found with id : " + id
                        )
                );

        theatreRepository.delete(theatre);
    }
}