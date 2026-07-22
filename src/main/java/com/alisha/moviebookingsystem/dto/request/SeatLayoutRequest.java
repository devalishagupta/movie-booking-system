package com.alisha.moviebookingsystem.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SeatLayoutRequest {

    @NotEmpty
    @Valid
    private List<RowConfiguration> rows;
}