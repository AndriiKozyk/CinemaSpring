package com.cinema.controller;

import com.cinema.dto.PlaceDto;
import com.cinema.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/places")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PlaceDto getPlace(@PathVariable int id) {
        return placeService.getPlace(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PlaceDto createPlace(@RequestBody PlaceDto placeDto) {
        return placeService.createPlace(placeDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public PlaceDto updatePlace(@PathVariable int id, @RequestBody PlaceDto placeDto) {
        return placeService.updatePlace(id, placeDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable int id) {
        placeService.deletePlace(id);
        return ResponseEntity.noContent().build();
    }

}
