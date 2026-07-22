package com.alisha.moviebookingsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ScreenCreateRequest {

    @NotBlank
    private String name;

    @NotNull
    private Integer screenNumber;

    @NotNull
    private UUID theatreId;
}