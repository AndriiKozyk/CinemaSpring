package com.cinema.service.impl;

import com.cinema.dto.UserDto;
import com.cinema.exception.UserNotFoundException;
import com.cinema.model.User;
import com.cinema.repository.UserRepository;
import com.cinema.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto getUser(String login) {
        User user = userRepository.findByLogin(login)
                .orElseThrow(UserNotFoundException::new);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapUserDtoToUser(userDto);
        user = userRepository.save(user);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(String login, UserDto userDto) {
        User user = mapUserDtoToUser(userDto);
        if (!userRepository.existsByLogin(login)) {
            throw new UserNotFoundException();
        }
        user = userRepository.save(user);
        return mapUserToUserDto(user);
    }

    @Override
    public void deleteUser(String login) {
        User user = userRepository.findByLogin(login)
                .orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }

    private UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .login(user.getLogin())
                .role(user.getRole())
                .build();
    }

    private User mapUserDtoToUser(UserDto userDto) {
        return User.builder()
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .role(userDto.getRole())
                .build();
    }

}
