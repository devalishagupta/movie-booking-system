package com.alisha.moviebookingsystem.mapper;

import com.alisha.moviebookingsystem.dto.response.ScreenResponse;
import com.alisha.moviebookingsystem.entity.Screen;
import org.springframework.stereotype.Component;


@Component
public class ScreenMapper {


    public ScreenResponse toResponse(Screen screen) {

        return ScreenResponse.builder()
                .id(screen.getId())
                .name(screen.getName())
                .screenNumber(screen.getScreenNumber())
                .theatreId(screen.getTheatre().getId())
                .theatreName(screen.getTheatre().getName())
                .build();
    }
}