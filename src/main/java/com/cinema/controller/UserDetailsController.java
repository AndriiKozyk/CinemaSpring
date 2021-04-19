package com.cinema.controller;

import com.cinema.dto.UserDetailsDto;
import com.cinema.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/details")
@RequiredArgsConstructor
public class UserDetailsController {

    private final UserDetailsService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public UserDetailsDto getDetails(@PathVariable Long id) {
        return service.getDetails(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDetailsDto createDetails(@RequestBody UserDetailsDto detailsDto) {
        return service.createDetails(detailsDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public UserDetailsDto updateDetails(@PathVariable Long id, @RequestBody UserDetailsDto detailsDto) {
        return service.updateDetails(id, detailsDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetails(@PathVariable Long id) {
        service.deleteDetails(id);
        return ResponseEntity.noContent().build();
    }

}
