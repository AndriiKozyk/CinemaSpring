package com.cinema.controller.assembler;

import com.cinema.controller.MovieSessionController;
import com.cinema.controller.model.MovieSessionPlaceModel;
import com.cinema.dto.MovieSessionPlaceDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MovieSessionPlaceAssembler extends
        RepresentationModelAssemblerSupport<MovieSessionPlaceDto, MovieSessionPlaceModel> {

    public MovieSessionPlaceAssembler() {
        super(MovieSessionController.class, MovieSessionPlaceModel.class);
    }

    @Override
    public MovieSessionPlaceModel toModel(MovieSessionPlaceDto entity) {

        MovieSessionPlaceModel movieSessionPlaceModel = new MovieSessionPlaceModel(entity);

        Link getSessionPlace = linkTo(methodOn(MovieSessionController.class)
                .getMovieSessionPlace(entity.getId())).withRel("getSessionPlace");
        Link updateSessionPlace = linkTo(methodOn(MovieSessionController.class)
                .updateMovieSessionPlace(entity.getId(), entity)).withRel("updateSessionPlace");
        Link deleteSession = linkTo(methodOn(MovieSessionController.class)
                .deleteMovieSession(entity.getId())).withRel("delete");

        movieSessionPlaceModel.add(getSessionPlace, updateSessionPlace, deleteSession);

        return movieSessionPlaceModel;
    }

}
