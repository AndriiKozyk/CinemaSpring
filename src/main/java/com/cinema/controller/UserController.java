package com.cinema.controller;

import com.cinema.api.UserApi;
import com.cinema.controller.assembler.UserAssembler;
import com.cinema.controller.model.UserModel;
import com.cinema.dto.UserDto;
import com.cinema.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;
    private final UserAssembler userAssembler;

    @Override
    public UserModel getUser(String login) {
        log.info("Get user by login: {}", login);
        UserDto user = userService.getUser(login);
        return userAssembler.toModel(user);
    }

    @Override
    public UserModel createUser(UserDto userDto) {
        log.info("Create user: {}", userDto);
        UserDto user = userService.createUser(userDto);
        return userAssembler.toModel(user);
    }

    @Override
    public UserModel updateUser(String login, UserDto userDto) {
        UserDto user = userService.updateUser(login, userDto);
        return userAssembler.toModel(user);
    }

    @Override
    public ResponseEntity<Void> deleteUser(String login) {
        userService.deleteUser(login);
        return ResponseEntity.noContent().build();
    }

}
