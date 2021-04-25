package com.cinema.controller.assembler;

import com.cinema.controller.MovieSessionController;
import com.cinema.controller.model.MovieSessionStatusModel;
import com.cinema.dto.MovieSessionStatusDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MovieSessionStatusAssembler extends
        RepresentationModelAssemblerSupport<MovieSessionStatusDto, MovieSessionStatusModel> {

    public MovieSessionStatusAssembler() {
        super(MovieSessionController.class, MovieSessionStatusModel.class);
    }

    @Override
    public MovieSessionStatusModel toModel(MovieSessionStatusDto entity) {

        MovieSessionStatusModel movieSessionStatusModel = new MovieSessionStatusModel(entity);

        Link getSession = linkTo(methodOn(MovieSessionController.class)
                .getMovieSessionGeneral(entity.getId())).withRel("getSession");
        Link updateSessionStatus = linkTo(methodOn(MovieSessionController.class)
                .updateMovieSessionStatus(entity.getId(), entity)).withRel("updateSessionStatus");
        Link deleteSession = linkTo(methodOn(MovieSessionController.class)
                .deleteMovieSession(entity.getId())).withRel("deleteSession");

        movieSessionStatusModel.add(getSession, updateSessionStatus, deleteSession);

        return movieSessionStatusModel;
    }

}
