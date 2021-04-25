package com.cinema.controller;

import com.cinema.controller.assembler.MovieSessionGeneralAssembler;
import com.cinema.controller.assembler.MovieSessionPlaceAssembler;
import com.cinema.controller.assembler.MovieSessionStatusAssembler;
import com.cinema.controller.model.MovieSessionGeneralModel;
import com.cinema.controller.model.MovieSessionPlaceModel;
import com.cinema.controller.model.MovieSessionStatusModel;
import com.cinema.dto.MovieSessionGeneralDto;
import com.cinema.dto.MovieSessionPlaceDto;
import com.cinema.dto.MovieSessionStatusDto;
import com.cinema.service.MovieSessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/sessions")
@RequiredArgsConstructor
public class MovieSessionController {

    private final MovieSessionService sessionService;
    private final MovieSessionGeneralAssembler movieSessionGeneralAssembler;
    private final MovieSessionPlaceAssembler movieSessionPlaceAssembler;
    private final MovieSessionStatusAssembler movieSessionStatusAssembler;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public MovieSessionGeneralModel getMovieSessionGeneral(@PathVariable Long id) {
        log.info("Get session by id: {}", id);
        MovieSessionGeneralDto sessionGeneral = sessionService.getMovieSessionGeneral(id);
        return movieSessionGeneralAssembler.toModel(sessionGeneral);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{idPlace}")
    public MovieSessionPlaceModel getMovieSessionPlace(@PathVariable Long idPlace) {
        log.info("Get session places by id: {}", idPlace);
        MovieSessionPlaceDto sessionPlace =  sessionService.getMovieSessionPlace(idPlace);
        return movieSessionPlaceAssembler.toModel(sessionPlace);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public MovieSessionGeneralModel createMovieSession(@RequestBody MovieSessionGeneralDto sessionGeneralDto) {
        log.info("Create session {}", sessionGeneralDto);
        MovieSessionGeneralDto sessionGeneral = sessionService.createMovieSession(sessionGeneralDto);
        return movieSessionGeneralAssembler.toModel(sessionGeneral);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public MovieSessionGeneralModel updateMovieSessionGeneral(@PathVariable Long id,
                                                            @RequestBody MovieSessionGeneralDto sessionGeneralDto) {
        log.info("Update session by id: {}", id);
        MovieSessionGeneralDto sessionGeneral = sessionService.updateMovieSessionGeneral(id, sessionGeneralDto);
        return movieSessionGeneralAssembler.toModel(sessionGeneral);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{idStatus}")
    public MovieSessionStatusModel updateMovieSessionStatus(@PathVariable Long idStatus,
                                                            @RequestBody MovieSessionStatusDto sessionStatusDto) {
        log.info("Update session status by id: {}", idStatus);
        MovieSessionStatusDto sessionStatus = sessionService.updateMovieSessionStatus(idStatus, sessionStatusDto);
        return movieSessionStatusAssembler.toModel(sessionStatus);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{idPlace}")
    public MovieSessionPlaceModel updateMovieSessionPlace(@PathVariable Long idPlace,
                                                        @RequestBody MovieSessionPlaceDto sessionPlaceDto) {
        log.info("Update session places by id: {}", idPlace);
        MovieSessionPlaceDto sessionPlace = sessionService.updateMovieSessionPlace(idPlace, sessionPlaceDto);
        return movieSessionPlaceAssembler.toModel(sessionPlace);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieSession(@PathVariable Long id) {
        sessionService.deleteMovieSession(id);
        log.info("Delete session by id: {}", id);
        return ResponseEntity.noContent().build();
    }

}
