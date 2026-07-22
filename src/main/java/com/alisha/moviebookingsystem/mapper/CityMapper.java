package com.alisha.moviebookingsystem.mapper;

import com.alisha.moviebookingsystem.dto.request.CityCreateRequest;
import com.alisha.moviebookingsystem.dto.response.CityResponse;
import com.alisha.moviebookingsystem.entity.City;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {

    public City toEntity(CityCreateRequest request){

        return City.builder()
                .name(request.getName())
                .build();
    }

    public CityResponse toResponse(City city){

        return CityResponse.builder()
                .id(city.getId())
                .name(city.getName())
                .build();
    }

}
