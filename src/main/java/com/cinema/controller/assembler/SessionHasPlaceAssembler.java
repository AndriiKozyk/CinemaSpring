package com.cinema.controller.assembler;

import com.cinema.controller.SessionHasPlaceController;
import com.cinema.controller.model.SessionHasPlaceModel;
import com.cinema.dto.SessionHasPlaceDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SessionHasPlaceAssembler extends
        RepresentationModelAssemblerSupport<SessionHasPlaceDto, SessionHasPlaceModel> {

    public SessionHasPlaceAssembler() {
        super(SessionHasPlaceController.class, SessionHasPlaceModel.class);
    }

    @Override
    public SessionHasPlaceModel toModel(SessionHasPlaceDto entity) {

        SessionHasPlaceModel sessionHasPlaceModel = new SessionHasPlaceModel(entity);

        Link get = linkTo(methodOn(SessionHasPlaceController.class)
                .getSessionHasPlace(entity.getId())).withRel("get");
        Link create = linkTo(methodOn(SessionHasPlaceController.class)
                .createSessionHasPlace(entity)).withRel("create");
        Link update = linkTo(methodOn(SessionHasPlaceController.class)
                .updateSessionHasPlace(entity.getId(), entity)).withRel("update");
        Link delete = linkTo(methodOn(SessionHasPlaceController.class)
                .deleteSessionHasPlace(entity.getId())).withRel("delete");

        sessionHasPlaceModel.add(get, create, update, delete);

        return sessionHasPlaceModel;
    }

}
