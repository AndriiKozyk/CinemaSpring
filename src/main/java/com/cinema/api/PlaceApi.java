package com.cinema.api;

import com.cinema.controller.model.PlaceModel;
import com.cinema.dto.PlaceDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Place management API")
@RequestMapping("/api/v1/places")
public interface PlaceApi {
    @ApiOperation("Get place from database")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    PlaceModel getPlace(@PathVariable int id);

    @ApiOperation("Create new place")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    PlaceModel createPlace(@RequestBody PlaceDto placeDto);

    @ApiOperation("Update place in database")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    PlaceModel updatePlace(@PathVariable int id, @RequestBody PlaceDto placeDto);

    @ApiOperation("Delete place from database")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletePlace(@PathVariable int id);
}
