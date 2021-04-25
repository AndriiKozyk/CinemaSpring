package com.cinema.api;

import com.cinema.controller.model.UserDetailsModel;
import com.cinema.dto.UserDetailsDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "User details management API")
@RequestMapping("/api/v1/details")
public interface UserDetailsApi {
    @ApiOperation("Get user details from database")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    UserDetailsModel getDetails(@PathVariable Long id);

    @ApiOperation("Create new user details")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserDetailsModel createDetails(@Valid @RequestBody UserDetailsDto detailsDto);

    @ApiOperation("Update user details in database")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    UserDetailsModel updateDetails(@PathVariable Long id, @Valid @RequestBody UserDetailsDto detailsDto);

    @ApiOperation("Delete user details from database")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteDetails(@PathVariable Long id);
}
