package com.cinema.controller.model;

import com.cinema.dto.UserDetailsDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class UserDetailsModel extends RepresentationModel<UserDetailsModel> {

    @JsonUnwrapped
    private UserDetailsDto userDetailsDto;

}
