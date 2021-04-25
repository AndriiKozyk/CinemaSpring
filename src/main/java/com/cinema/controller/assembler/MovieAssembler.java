package com.cinema.controller.assembler;

import com.cinema.controller.MovieController;
import com.cinema.controller.model.MovieModel;
import com.cinema.dto.MovieDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MovieAssembler extends RepresentationModelAssemblerSupport<MovieDto, MovieModel> {

    public MovieAssembler() {
        super(MovieController.class, MovieModel.class);
    }

    @Override
    public MovieModel toModel(MovieDto entity) {

        MovieModel movieModel = new MovieModel(entity);

        Link get = linkTo(methodOn(MovieController.class).getMovie(entity.getId())).withRel("get");
        Link create = linkTo(methodOn(MovieController.class).createMovie(entity)).withRel("create");
        Link update = linkTo(methodOn(MovieController.class).updateMovie(entity.getId(), entity)).withRel("update");
        Link delete = linkTo(methodOn(MovieController.class).deleteMovie(entity.getId())).withRel("delete");

        movieModel.add(get, create, update, delete);

        return movieModel;
    }

}
