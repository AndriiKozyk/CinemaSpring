package com.cinema.controller;

import com.cinema.controller.assembler.UserDetailsAssembler;
import com.cinema.controller.model.UserDetailsModel;
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
    private final UserDetailsAssembler userDetailsAssembler;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public UserDetailsModel getDetails(@PathVariable Long id) {
        log.info("Get user details by id: {}", id);
        UserDetailsDto details = service.getDetails(id);
        return userDetailsAssembler.toModel(details);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDetailsModel createDetails(@Valid @RequestBody UserDetailsDto detailsDto) {
        log.info("Create user details {}", detailsDto);
        UserDetailsDto details = service.createDetails(detailsDto);
        return userDetailsAssembler.toModel(details);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public UserDetailsModel updateDetails(@PathVariable Long id, @Valid @RequestBody UserDetailsDto detailsDto) {
        log.info("Update user details by id: {}", id);
        UserDetailsDto details = service.updateDetails(id, detailsDto);
        return userDetailsAssembler.toModel(details);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetails(@PathVariable Long id) {
        log.info("Delete user details by id: {}", id);
        service.deleteDetails(id);
        return ResponseEntity.noContent().build();
    }

}
