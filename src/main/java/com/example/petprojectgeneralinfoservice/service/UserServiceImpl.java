package com.example.petprojectgeneralinfoservice.service;

import com.example.petprojectgeneralinfoservice.data.dto.UserDto;
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
}
