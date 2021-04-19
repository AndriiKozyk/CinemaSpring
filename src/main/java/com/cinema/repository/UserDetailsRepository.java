package com.cinema.repository;

import com.cinema.model.UserDetails;

public interface UserDetailsRepository {
    UserDetails getDetails(Long userId);

    UserDetails createDetails(UserDetails details);

    UserDetails updateDetails(Long userId, UserDetails details);

    void deleteDetails(Long userId);
}
