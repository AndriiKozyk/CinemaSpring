package com.cinema.repository.impl;

import com.cinema.model.User;
import com.cinema.repository.UserRepository;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {

    private final List<User> list = new ArrayList<>();

    @Override
    public User getUser(String login) {
        return list.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public User createUser(User user) {
        list.add(user);
        return user;
    }

    @Override
    public User updateUser(String login, User user) {
        boolean isDeleted = list.removeIf(u -> u.getLogin().equals(login));
        if (isDeleted) {
            list.add(user);
        } else {
            throw new RuntimeException("User does not exist with login " + login);
        }
        return user;
    }

    @Override
    public void deleteUser(String login) {
        list.removeIf(user -> user.getLogin().equals(login));
    }

}
