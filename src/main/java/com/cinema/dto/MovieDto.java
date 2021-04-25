package com.cinema.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class MovieDto {

    private int id;
    private String name;
    private int duration;
    private BigDecimal price;
    private Long genreId;

}
