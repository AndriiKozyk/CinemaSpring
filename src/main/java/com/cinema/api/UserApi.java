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
    @ApiOperation("Get user from database")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{login}")
    UserModel getUser(@PathVariable String login);

    @ApiOperation("Create new user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserModel createUser(@Valid @RequestBody UserDto userDto);

    @ApiOperation("Update user in database")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{login}")
    UserModel updateUser(@PathVariable String login, @Valid @RequestBody UserDto userDto);

    @ApiOperation("Delete user from database")
    @DeleteMapping("/{login}")
    ResponseEntity<Void> deleteUser(@PathVariable String login);
}
