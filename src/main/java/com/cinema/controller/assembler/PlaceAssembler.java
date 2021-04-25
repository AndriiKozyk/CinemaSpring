package com.cinema.controller.assembler;

import com.cinema.controller.PlaceController;
import com.cinema.controller.model.PlaceModel;
import com.cinema.dto.PlaceDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PlaceAssembler extends RepresentationModelAssemblerSupport<PlaceDto, PlaceModel> {

    public PlaceAssembler() {
        super(PlaceController.class, PlaceModel.class);
    }

    @Override
    public PlaceModel toModel(PlaceDto entity) {

        PlaceModel placeModel = new PlaceModel(entity);

        Link get = linkTo(methodOn(PlaceController.class).getPlace(entity.getId())).withRel("get");
        Link create = linkTo(methodOn(PlaceController.class).createPlace(entity)).withRel("create");
        Link update = linkTo(methodOn(PlaceController.class).updatePlace(entity.getId(), entity)).withRel("update");
        Link delete = linkTo(methodOn(PlaceController.class).deletePlace(entity.getId())).withRel("delete");

        placeModel.add(get, create, update, delete);

        return placeModel;
    }

}
