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
public class UserDto {

    private int id;
    private String login;
    private String password;
    private String repeatPassword;
    private String role;
    private String firstName;
    private String lastName;
    @NotNull
    @Email
    private String email;
    private String phone;

}
