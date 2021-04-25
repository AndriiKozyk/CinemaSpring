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
    @NotNull(message = "First name can not be null")
    private String firstName;
    @NotNull(message = "Last name can not be null")
    private String lastName;
    @NotNull(message = "Phone number can not be null")
    private String phone;
    @NotNull(message = "Email can not be null")
    @Email(message = "Should be like email@email.com")
    private String email;

}
