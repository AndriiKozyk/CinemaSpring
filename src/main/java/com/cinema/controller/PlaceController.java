package com.cinema.controller;

import com.cinema.controller.assembler.PlaceAssembler;
import com.cinema.controller.model.PlaceModel;
import com.cinema.dto.PlaceDto;
import com.cinema.service.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/places")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;
    private final PlaceAssembler placeAssembler;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PlaceModel getPlace(@PathVariable int id) {
        log.info("Get place by id: {}", id);
        PlaceDto place = placeService.getPlace(id);
        return placeAssembler.toModel(place);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PlaceModel createPlace(@RequestBody PlaceDto placeDto) {
        log.info("Create place {}", placeDto);
        PlaceDto place = placeService.createPlace(placeDto);
        return placeAssembler.toModel(place);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public PlaceModel updatePlace(@PathVariable int id, @RequestBody PlaceDto placeDto) {
        log.info("Update place by id: {}", id);
        PlaceDto place = placeService.updatePlace(id, placeDto);
        return placeAssembler.toModel(place);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable int id) {
        placeService.deletePlace(id);
        log.info("Delete place by id: {}", id);
        return ResponseEntity.noContent().build();
    }

}
