package com.alisha.moviebookingsystem.service.impl;

import com.alisha.moviebookingsystem.dto.request.CityCreateRequest;
import com.alisha.moviebookingsystem.dto.response.CityResponse;
import com.alisha.moviebookingsystem.entity.City;
import com.alisha.moviebookingsystem.exception.DuplicateResourceException;
import com.alisha.moviebookingsystem.exception.ResourceNotFoundException;
import com.alisha.moviebookingsystem.mapper.CityMapper;
import com.alisha.moviebookingsystem.repository.CityRepository;
import com.alisha.moviebookingsystem.service.interfaces.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    @Override
    public CityResponse createCity(CityCreateRequest request) {

        cityRepository.findByNameIgnoreCase(request.getName())
                .ifPresent(city -> {
                    throw new DuplicateResourceException(
                            "City already exists with name : " + request.getName()
                    );
                });

        City city = cityMapper.toEntity(request);

        City savedCity = cityRepository.save(city);

        return cityMapper.toResponse(savedCity);
    }

    @Override
    public List<CityResponse> getAllCities() {

        return cityRepository.findAll()
                .stream()
                .map(cityMapper::toResponse)
                .toList();
    }

    @Override
    public CityResponse getCity(UUID id) {

        City city = cityRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "City not found with id : " + id
                        ));

        return cityMapper.toResponse(city);
    }

    @Override
    public void deleteCity(UUID id) {

        City city = cityRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "City not found with id : " + id
                        ));

        cityRepository.delete(city);
    }
}