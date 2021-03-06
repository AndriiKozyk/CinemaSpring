package com.cinema.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetails {

    private Long userId;
    private String firstName;
    private String lastName;
    private String phone;

}
