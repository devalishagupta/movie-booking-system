package com.alisha.moviebookingsystem.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class ScreenResponse {

    private UUID id;

    private String name;

    private Integer screenNumber;

    private UUID theatreId;

    private String theatreName;
}