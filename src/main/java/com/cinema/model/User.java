package com.cinema.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private int id;
    private String login;
    private String password;
    private String role;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

}
