package com.cinema.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenreDto {

    private Long id;
    private String genre;

}