package com.cinema.api;

import com.cinema.controller.model.UserModel;
import com.cinema.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "User management API")
@RequestMapping("/api/v1/users")
public interface UserApi {

    @ApiOperation("Get use from database")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{login}")
    UserModel getUser(@PathVariable String login);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserModel createUser(@Valid @RequestBody UserDto userDto);

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{login}")
    UserModel updateUser(@PathVariable String login, @Valid @RequestBody UserDto userDto);

    @DeleteMapping("/{login}")
    ResponseEntity<Void> deleteUser(@PathVariable String login);
}
