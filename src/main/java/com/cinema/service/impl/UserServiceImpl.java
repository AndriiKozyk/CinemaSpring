package com.cinema.service.impl;

import com.cinema.dto.UserDto;
import com.cinema.model.User;
import com.cinema.repository.UserRepository;
import com.cinema.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto getUser(String login) {
        log.info("getUser by login {}", login);
        User user = userRepository.getUser(login);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapUserDtoToUser(userDto);
        user = userRepository.createUser(user);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(String login, UserDto userDto) {
        User user = mapUserDtoToUser(userDto);
        user = userRepository.updateUser(login, user);
        return mapUserToUserDto(user);
    }

    @Override
    public void deleteUser(String login) {
        userRepository.deleteUser(login);
    }

    private UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .role(user.getRole())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }

    private User mapUserDtoToUser(UserDto userDto) {
        return User.builder()
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .role(userDto.getRole())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .build();
    }

}
