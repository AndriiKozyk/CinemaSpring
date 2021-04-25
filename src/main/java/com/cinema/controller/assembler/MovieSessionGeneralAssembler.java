package com.cinema.controller.assembler;

import com.cinema.controller.MovieSessionController;
import com.cinema.controller.model.MovieSessionGeneralModel;
import com.cinema.dto.MovieSessionGeneralDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MovieSessionGeneralAssembler extends
        RepresentationModelAssemblerSupport<MovieSessionGeneralDto, MovieSessionGeneralModel> {

    public MovieSessionGeneralAssembler() {
        super(MovieSessionController.class, MovieSessionGeneralModel.class);
    }

    @Override
    public MovieSessionGeneralModel toModel(MovieSessionGeneralDto entity) {

        MovieSessionGeneralModel movieSessionGeneralModel = new MovieSessionGeneralModel(entity);

        Link getSession = linkTo(methodOn(MovieSessionController.class)
                .getMovieSessionGeneral(entity.getId())).withRel("getSession");
        Link createSession = linkTo(methodOn(MovieSessionController.class)
                .createMovieSession(entity)).withRel("createSession");
        Link updateSession = linkTo(methodOn(MovieSessionController.class)
                .updateMovieSessionGeneral(entity.getId(), entity)).withRel("updateSession");
        Link deleteSession = linkTo(methodOn(MovieSessionController.class)
                .deleteMovieSession(entity.getId())).withRel("deleteSession");

        movieSessionGeneralModel.add(getSession, createSession, updateSession, deleteSession);

        return movieSessionGeneralModel;
    }

}
