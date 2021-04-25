package com.cinema.controller;

import com.cinema.api.MovieSessionApi;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MovieSessionController implements MovieSessionApi {

    private final MovieSessionService sessionService;
    private final MovieSessionGeneralAssembler movieSessionGeneralAssembler;
    private final MovieSessionPlaceAssembler movieSessionPlaceAssembler;
    private final MovieSessionStatusAssembler movieSessionStatusAssembler;

    @Override
    public MovieSessionGeneralModel getMovieSessionGeneral(Long id) {
        log.info("Get session by id: {}", id);
        MovieSessionGeneralDto sessionGeneral = sessionService.getMovieSessionGeneral(id);
        return movieSessionGeneralAssembler.toModel(sessionGeneral);
    }

    @Override
    public MovieSessionPlaceModel getMovieSessionPlace(Long idPlace) {
        log.info("Get session places by id: {}", idPlace);
        MovieSessionPlaceDto sessionPlace =  sessionService.getMovieSessionPlace(idPlace);
        return movieSessionPlaceAssembler.toModel(sessionPlace);
    }

    @Override
    public MovieSessionGeneralModel createMovieSession(MovieSessionGeneralDto sessionGeneralDto) {
        log.info("Create session {}", sessionGeneralDto);
        MovieSessionGeneralDto sessionGeneral = sessionService.createMovieSession(sessionGeneralDto);
        return movieSessionGeneralAssembler.toModel(sessionGeneral);
    }

    @Override
    public MovieSessionGeneralModel updateMovieSessionGeneral(Long id, MovieSessionGeneralDto sessionGeneralDto) {
        log.info("Update session by id: {}", id);
        MovieSessionGeneralDto sessionGeneral = sessionService.updateMovieSessionGeneral(id, sessionGeneralDto);
        return movieSessionGeneralAssembler.toModel(sessionGeneral);
    }

    @Override
    public MovieSessionStatusModel updateMovieSessionStatus(Long idStatus, MovieSessionStatusDto sessionStatusDto) {
        log.info("Update session status by id: {}", idStatus);
        MovieSessionStatusDto sessionStatus = sessionService.updateMovieSessionStatus(idStatus, sessionStatusDto);
        return movieSessionStatusAssembler.toModel(sessionStatus);
    }

    @Override
    public MovieSessionPlaceModel updateMovieSessionPlace(Long idPlace, MovieSessionPlaceDto sessionPlaceDto) {
        log.info("Update session places by id: {}", idPlace);
        MovieSessionPlaceDto sessionPlace = sessionService.updateMovieSessionPlace(idPlace, sessionPlaceDto);
        return movieSessionPlaceAssembler.toModel(sessionPlace);
    }

    @Override
    public ResponseEntity<Void> deleteMovieSession(Long id) {
        sessionService.deleteMovieSession(id);
        log.info("Delete session by id: {}", id);
        return ResponseEntity.noContent().build();
    }

}
