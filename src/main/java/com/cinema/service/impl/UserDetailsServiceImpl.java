package com.cinema.service.impl;

import com.cinema.dto.UserDetailsDto;
import com.cinema.model.UserDetails;
import com.cinema.repository.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements com.cinema.service.UserDetailsService {

    private final UserDetailsRepository repository;

    @Override
    public UserDetailsDto getDetails(Long userId) {
        UserDetails details = repository.getDetails(userId);
        return mapDetailsToDetailsDto(details);
    }

    @Override
    public UserDetailsDto createDetails(UserDetailsDto detailsDto) {
        UserDetails details = mapDetailsDtoToDetails(detailsDto);
        repository.createDetails(details);
        return detailsDto;
    }

    @Override
    public UserDetailsDto updateDetails(Long id, UserDetailsDto detailsDto) {
        UserDetails details = mapDetailsDtoToDetails(detailsDto);
        repository.updateDetails(id, details);
        return detailsDto;
    }

    @Override
    public void deleteDetails(Long id) {
        repository.deleteDetails(id);
    }

    private UserDetails mapDetailsDtoToDetails(UserDetailsDto detailsDto) {
        return UserDetails.builder()
                .firstName(detailsDto.getFirstName())
                .lastName(detailsDto.getLastName())
                .phone(detailsDto.getPhone())
                .build();
    }

    private UserDetailsDto mapDetailsToDetailsDto(UserDetails details) {
        return UserDetailsDto.builder()
                .userId(details.getUserId())
                .firstName(details.getFirstName())
                .lastName(details.getLastName())
                .phone(details.getPhone())
                .build();
    }

}
