package com.cinema.controller.assembler;

import com.cinema.controller.GenreController;
import com.cinema.controller.model.GenreModel;
import com.cinema.dto.GenreDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class GenreAssembler extends RepresentationModelAssemblerSupport<GenreDto, GenreModel> {

    public GenreAssembler() {
        super(GenreController.class, GenreModel.class);
    }

    @Override
    public GenreModel toModel(GenreDto entity) {

        GenreModel genreModel = new GenreModel(entity);

        Link get = linkTo(methodOn(GenreController.class).getGenre(entity.getId())).withRel("get");
        Link create = linkTo(methodOn(GenreController.class).createGenre(entity)).withRel("create");
        Link update = linkTo(methodOn(GenreController.class).updateGenre(entity.getId(), entity)).withRel("update");
        Link delete = linkTo(methodOn(GenreController.class).deleteGenre(entity.getId())).withRel("delete");

        genreModel.add(get, create, update, delete);

        return genreModel;
    }

}
