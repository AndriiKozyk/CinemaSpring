package com.cinema.controller;

import com.cinema.api.PlaceApi;
import com.cinema.controller.assembler.PlaceAssembler;
import com.cinema.controller.model.PlaceModel;
import com.cinema.dto.PlaceDto;
import com.cinema.service.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PlaceController implements PlaceApi {

    private final PlaceService placeService;
    private final PlaceAssembler placeAssembler;

    @Override
    public PlaceModel getPlace(int id) {
        log.info("Get place by id: {}", id);
        PlaceDto place = placeService.getPlace(id);
        return placeAssembler.toModel(place);
    }

    @Override
    public PlaceModel createPlace(PlaceDto placeDto) {
        log.info("Create place {}", placeDto);
        PlaceDto place = placeService.createPlace(placeDto);
        return placeAssembler.toModel(place);
    }

    @Override
    public PlaceModel updatePlace(int id, PlaceDto placeDto) {
        log.info("Update place by id: {}", id);
        PlaceDto place = placeService.updatePlace(id, placeDto);
        return placeAssembler.toModel(place);
    }

    @Override
    public ResponseEntity<Void> deletePlace(int id) {
        placeService.deletePlace(id);
        log.info("Delete place by id: {}", id);
        return ResponseEntity.noContent().build();
    }

}
