package com.cinema.controller.assembler;

import com.cinema.controller.UserController;
import com.cinema.controller.model.UserModel;
import com.cinema.dto.UserDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<UserDto, UserModel> {

    public UserAssembler() {
        super(UserController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(UserDto entity) {

        UserModel userModel = new UserModel(entity);

        Link get = linkTo(methodOn(UserController.class).getUser(entity.getLogin())).withRel("get");
        Link delete = linkTo(methodOn(UserController.class).deleteUser(entity.getLogin())).withRel("delete");

        userModel.add(get, delete);

        return userModel;
    }

}
