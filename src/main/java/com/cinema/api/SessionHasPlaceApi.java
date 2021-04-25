package com.cinema.api;

import com.cinema.controller.model.SessionHasPlaceModel;
import com.cinema.dto.SessionHasPlaceDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Sessions place management API")
@RequestMapping("/api/v1/shps")
public interface SessionHasPlaceApi {
    @ApiOperation("Get sessions place from database")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    SessionHasPlaceModel getSessionHasPlace(@PathVariable int id);

    @ApiOperation("Create new sessions place")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    SessionHasPlaceModel createSessionHasPlace(@RequestBody SessionHasPlaceDto sessionHasPlaceDto);

    @ApiOperation("Update sessions place in database")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    SessionHasPlaceModel updateSessionHasPlace(@PathVariable int id,
                                               @RequestBody SessionHasPlaceDto sessionHasPlaceDto);

    @ApiOperation("Delete sessions place from database")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteSessionHasPlace(@PathVariable int id);
}
