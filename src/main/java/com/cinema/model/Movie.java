package com.cinema.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Movie {

    private int id;
    private String name;
    private int duration;
    private BigDecimal price;
    private String genre;

}
