package com.cinema.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
public class MovieDto {

    private int id;
    @NotNull(message = "Movie name can not be null")
    private String name;
    private int duration;
    private BigDecimal price;
    private Long genreId;

}
