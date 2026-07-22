package com.alisha.moviebookingsystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CityResponse {

    private UUID id;

    private String name;

}
