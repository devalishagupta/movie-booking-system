package com.alisha.moviebookingsystem.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class TheatreResponse {

    private UUID id;

    private String name;

    private String address;

    private UUID cityId;

    private String cityName;
}