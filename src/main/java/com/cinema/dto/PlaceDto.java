package com.cinema.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlaceDto {

    private int id;
    private int number;
    private int row;

}
