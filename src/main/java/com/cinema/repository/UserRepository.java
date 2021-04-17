package com.cinema.repository;

import com.cinema.model.User;

public interface UserRepository {

    User getUser(String login);

    User createUser(User user);

    User updateUser(String login, User user);

    void deleteUser(String login);

}
