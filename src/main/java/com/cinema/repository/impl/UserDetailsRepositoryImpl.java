package com.cinema.repository.impl;

import com.cinema.model.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailsRepositoryImpl implements com.cinema.repository.UserDetailsRepository {

    private final List<UserDetails> list = new ArrayList<>();

    @Override
    public UserDetails getDetails(Long userId) {
        return list.stream()
                .filter(details -> details.getUserId().equals(userId))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public UserDetails createDetails(UserDetails details) {
        list.add(details);
        return details;
    }

    @Override
    public UserDetails updateDetails(Long userId, UserDetails details) {
        boolean isDeleted = list.removeIf(d -> d.getUserId().equals(userId));
        if (isDeleted) {
            list.add(details);
        } else {
            throw new RuntimeException("Details does not exist");
        }
        return details;
    }

    @Override
    public void deleteDetails(Long userId) {
        list.removeIf(details -> details.getUserId().equals(userId));
    }

}
