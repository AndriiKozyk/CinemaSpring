package com.cinema.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Place {

    private int id;
    private int number;
    private int row;

}
