package com.alisha.moviebookingsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityCreateRequest {

    @NotBlank
    private String name;

}
