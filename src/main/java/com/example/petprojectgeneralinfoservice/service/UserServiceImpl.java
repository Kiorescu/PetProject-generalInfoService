package com.example.petprojectgeneralinfoservice.service;

import com.example.petprojectgeneralinfoservice.data.dto.UserCreationRequest;
import com.example.petprojectgeneralinfoservice.data.dto.UserDto;
import com.example.petprojectgeneralinfoservice.data.entity.User;
import com.example.petprojectgeneralinfoservice.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<UserDto> findByUsername(String username) {
        Optional<UserDto> user = userRepository.findByUsername(username).map(UserDto::fromUser);

        if (user.isEmpty()) {
            log.warn("User {} not found", username);
        }

        return user;
    }

    @Override
    public UserDto createUser(UserCreationRequest user) {
        User userEntity = User.builder()
                .name(user.getName())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();

        UserDto createdUser = UserDto.fromUser(userRepository.save(userEntity));
        log.info("User {} created", user.getUsername());
        return createdUser;
    }
}
