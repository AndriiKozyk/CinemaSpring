package com.cinema.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class MovieDto {

    private int id;
    @NotNull(message = "Movie name can not be null")
    private String name;
    private int duration;
    private BigDecimal price;
    private Long genreId;

}
