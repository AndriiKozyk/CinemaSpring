package com.cinema.controller;

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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PlaceDto getPlace(@PathVariable int id) {
        log.info("Get place by id: {}", id);
        return placeService.getPlace(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PlaceDto createPlace(@RequestBody PlaceDto placeDto) {
        log.info("Create place {}", placeDto);
        return placeService.createPlace(placeDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public PlaceDto updatePlace(@PathVariable int id, @RequestBody PlaceDto placeDto) {
        log.info("Update place by id: {}", id);
        return placeService.updatePlace(id, placeDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable int id) {
        placeService.deletePlace(id);
        log.info("Delete place by id: {}", id);
        return ResponseEntity.noContent().build();
    }

}
