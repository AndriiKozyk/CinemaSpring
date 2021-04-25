package com.cinema.controller;

import com.cinema.dto.UserDetailsDto;
import com.cinema.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/v1/details")
@RequiredArgsConstructor
public class UserDetailsController {

    private final UserDetailsService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public UserDetailsDto getDetails(@PathVariable Long id) {
        log.info("Get user details by id: {}", id);
        return service.getDetails(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDetailsDto createDetails(@Valid @RequestBody UserDetailsDto detailsDto) {
        log.info("Create user details {}", detailsDto);
        return service.createDetails(detailsDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public UserDetailsDto updateDetails(@PathVariable Long id, @Valid @RequestBody UserDetailsDto detailsDto) {
        log.info("Update user details by id: {}", id);
        return service.updateDetails(id, detailsDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetails(@PathVariable Long id) {
        log.info("Delete user details by id: {}", id);
        service.deleteDetails(id);
        return ResponseEntity.noContent().build();
    }

}
