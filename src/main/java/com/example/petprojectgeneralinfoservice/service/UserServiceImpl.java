package com.example.petprojectgeneralinfoservice.service;

import com.example.petprojectgeneralinfoservice.data.dto.UserCreationRequest;
import com.example.petprojectgeneralinfoservice.data.dto.UserDetailDto;
import com.example.petprojectgeneralinfoservice.data.dto.UserDto;
import com.example.petprojectgeneralinfoservice.data.entity.User;
import com.example.petprojectgeneralinfoservice.data.repository.UserRepository;
import com.example.petprojectgeneralinfoservice.util.exceptions.UserExistsException;
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
    public Optional<UserDetailDto> getUserDetails(String username) {
        Optional<UserDetailDto> user = userRepository.findByUsername(username).map(UserDetailDto::fromUser);

        if (user.isEmpty()) {
            log.warn("User {} not found", username);
        }

        return user;
    }

    @Override
    public UserDto createUser(UserCreationRequest userCreationRequest) {
        Optional<User> userOptional = userRepository.findByUsername(userCreationRequest.getUsername());
        if (userOptional.isPresent()) {
            log.debug("User {} already exists", userCreationRequest.getUsername());
            throw new UserExistsException("User " + userCreationRequest.getUsername() + " already exists");
        }

        User userEntity = User.builder()
                .name(userCreationRequest.getName())
                .username(userCreationRequest.getUsername())
                .password(userCreationRequest.getPassword())
                .build();

        UserDto createdUser = UserDto.fromUser(userRepository.save(userEntity));
        log.info("User {} created", userCreationRequest.getUsername());
        return createdUser;
    }
}
