package com.cinema.dto;

import com.cinema.model.enums.Role;
import com.cinema.validator.RepeatPassword;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
@RepeatPassword
public class UserDto {

    @NotNull(message = "Login can not be null")
    @Size(min = 3, max = 20)
    private String login;
    @NotNull(message = "Password can not be null")
    @Size(min = 5, message = "Password must be longer than 5")
    private String password;
    @NotNull(message = "Password can not be null")
    @Size(min = 5, message = "Password must be longer than 5")
    private String repeatPassword;
    private Role role;

}
