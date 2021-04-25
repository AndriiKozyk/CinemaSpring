package com.cinema.controller;

import com.cinema.api.UserDetailsApi;
import com.cinema.controller.assembler.UserDetailsAssembler;
import com.cinema.controller.model.UserDetailsModel;
import com.cinema.dto.UserDetailsDto;
import com.cinema.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserDetailsController implements UserDetailsApi {

    private final UserDetailsService service;
    private final UserDetailsAssembler userDetailsAssembler;

    @Override
    public UserDetailsModel getDetails(Long id) {
        log.info("Get user details by id: {}", id);
        UserDetailsDto details = service.getDetails(id);
        return userDetailsAssembler.toModel(details);
    }

    @Override
    public UserDetailsModel createDetails(UserDetailsDto detailsDto) {
        log.info("Create user details {}", detailsDto);
        UserDetailsDto details = service.createDetails(detailsDto);
        return userDetailsAssembler.toModel(details);
    }

    @Override
    public UserDetailsModel updateDetails(Long id, UserDetailsDto detailsDto) {
        log.info("Update user details by id: {}", id);
        UserDetailsDto details = service.updateDetails(id, detailsDto);
        return userDetailsAssembler.toModel(details);
    }

    @Override
    public ResponseEntity<Void> deleteDetails(Long id) {
        log.info("Delete user details by id: {}", id);
        service.deleteDetails(id);
        return ResponseEntity.noContent().build();
    }

}
