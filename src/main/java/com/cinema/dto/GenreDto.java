package com.cinema.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class GenreDto {

    private Long id;
    @NotNull(message = "Genre can not be null")
    private String genre;

}
