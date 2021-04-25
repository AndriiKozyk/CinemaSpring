package com.cinema.controller.assembler;

import com.cinema.controller.UserDetailsController;
import com.cinema.controller.model.UserDetailsModel;
import com.cinema.dto.UserDetailsDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserDetailsAssembler extends RepresentationModelAssemblerSupport<UserDetailsDto, UserDetailsModel> {

    public UserDetailsAssembler() {
        super(UserDetailsController.class, UserDetailsModel.class);
    }

    @Override
    public UserDetailsModel toModel(UserDetailsDto entity) {
        UserDetailsModel userDetailsModel = new UserDetailsModel(entity);

        Link get = linkTo(methodOn(UserDetailsController.class).getDetails(entity.getUserId())).withRel("get");
        Link create = linkTo(methodOn(UserDetailsController.class).createDetails(entity)).withRel("create");
        Link update = linkTo(methodOn(UserDetailsController.class)
                .updateDetails(entity.getUserId(), entity))
                .withRel("update");
        Link delete = linkTo(methodOn(UserDetailsController.class).deleteDetails(entity.getUserId())).withRel("delete");

        userDetailsModel.add(get, create, update, delete);

        return userDetailsModel;
    }

}
