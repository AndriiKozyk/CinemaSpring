package com.cinema.service;

import com.cinema.dto.UserDetailsDto;

public interface UserDetailsService {
    UserDetailsDto getDetails(Long userId);

    UserDetailsDto createDetails(UserDetailsDto detailsDto);

    UserDetailsDto updateDetails(Long id, UserDetailsDto detailsDto);

    void deleteDetails(Long id);
}
