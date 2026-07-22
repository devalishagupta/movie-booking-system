package com.alisha.moviebookingsystem.mapper;

import com.alisha.moviebookingsystem.dto.response.TheatreResponse;
import com.alisha.moviebookingsystem.entity.Theatre;
import org.springframework.stereotype.Component;

@Component
public class TheatreMapper {


    public TheatreResponse toResponse(Theatre theatre) {

        return TheatreResponse.builder()
                .id(theatre.getId())
                .name(theatre.getName())
                .address(theatre.getAddress())
                .cityId(theatre.getCity().getId())
                .cityName(theatre.getCity().getName())
                .build();
    }
}