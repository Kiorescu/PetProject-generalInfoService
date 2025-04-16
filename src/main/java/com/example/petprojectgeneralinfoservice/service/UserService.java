package com.example.petprojectgeneralinfoservice.service;

import com.example.petprojectgeneralinfoservice.data.dto.UserDto;

import java.util.Optional;

public interface UserService {

    Optional<UserDto> findByUsername(String username);
}
