package com.cinema.api;

import com.cinema.controller.model.MovieSessionGeneralModel;
import com.cinema.controller.model.MovieSessionPlaceModel;
import com.cinema.controller.model.MovieSessionStatusModel;
import com.cinema.dto.MovieSessionGeneralDto;
import com.cinema.dto.MovieSessionPlaceDto;
import com.cinema.dto.MovieSessionStatusDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Movie session management API")
@RequestMapping("/api/v1/sessions")
public interface MovieSessionApi {
    @ApiOperation("Get movie session from database")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    MovieSessionGeneralModel getMovieSessionGeneral(@PathVariable Long id);

    @ApiOperation("Get movie session places from database")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{idPlace}")
    MovieSessionPlaceModel getMovieSessionPlace(@PathVariable Long idPlace);

    @ApiOperation("Create new movie session")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    MovieSessionGeneralModel createMovieSession(@RequestBody MovieSessionGeneralDto sessionGeneralDto);

    @ApiOperation("Update movie session in database")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    MovieSessionGeneralModel updateMovieSessionGeneral(@PathVariable Long id,
                                                       @RequestBody MovieSessionGeneralDto sessionGeneralDto);

    @ApiOperation("Update movie session status in database")
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{idStatus}")
    MovieSessionStatusModel updateMovieSessionStatus(@PathVariable Long idStatus,
                                                     @RequestBody MovieSessionStatusDto sessionStatusDto);

    @ApiOperation("Update movie session place in database")
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{idPlace}")
    MovieSessionPlaceModel updateMovieSessionPlace(@PathVariable Long idPlace,
                                                   @RequestBody MovieSessionPlaceDto sessionPlaceDto);

    @ApiOperation("Delete movie session in database")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteMovieSession(@PathVariable Long id);
}
