package com.cinema.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetailsDto {

    private Long userId;
    private String firstName;
    private String lastName;
    private String phone;

}
