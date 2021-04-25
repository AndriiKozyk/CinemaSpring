package com.cinema.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class UserDetailsDto {

    private Long userId;
    private String firstName;
    private String lastName;
    private String phone;
    @NotNull
    @Email(message = "Should be like email@email.com")
    private String email;

}
