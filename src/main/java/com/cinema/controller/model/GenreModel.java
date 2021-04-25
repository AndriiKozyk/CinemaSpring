package com.cinema.controller.model;

import com.cinema.dto.GenreDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class GenreModel extends RepresentationModel<GenreModel> {

    @JsonUnwrapped
    private GenreDto genreDto;

}
