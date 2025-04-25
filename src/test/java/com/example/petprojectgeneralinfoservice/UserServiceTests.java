package com.example.petprojectgeneralinfoservice;


import com.example.petprojectgeneralinfoservice.data.dto.UserCreationRequest;
import com.example.petprojectgeneralinfoservice.data.dto.UserDetailDto;
import com.example.petprojectgeneralinfoservice.data.dto.UserDto;
import com.example.petprojectgeneralinfoservice.data.entity.User;
import com.example.petprojectgeneralinfoservice.data.repository.UserRepository;
import com.example.petprojectgeneralinfoservice.service.UserService;
import com.example.petprojectgeneralinfoservice.service.UserServiceImpl;
import com.example.petprojectgeneralinfoservice.util.exceptions.UserExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTests {

    private final String TEST_USERNAME = "test";
    private final String EMPTY_USERNAME = "empty";
    private final UserRepository userRepository = Mockito.mock(UserRepository.class);
    private final User user = Mockito.mock(User.class);
    private final UserService userService = new UserServiceImpl(userRepository);

    @BeforeEach
    public void setUp() {
        Mockito.when(userRepository.findByUsername(TEST_USERNAME)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.findByUsername(EMPTY_USERNAME)).thenReturn(Optional.empty());
    }

    @Test
    public void testFindByUsername() {
        Optional<UserDto> result = userService.findByUsername(TEST_USERNAME);
        Optional<UserDto> emptyResult = userService.findByUsername(EMPTY_USERNAME);

        assertTrue(result.isPresent());
        assertTrue(emptyResult.isEmpty());
    }

    @Test
    public void testFindUserDetails() {
        Optional<UserDetailDto> result = userService.getUserDetails(TEST_USERNAME);
        Optional<UserDetailDto> emptyResult = userService.getUserDetails(EMPTY_USERNAME);

        assertTrue(result.isPresent());
        assertTrue(emptyResult.isEmpty());
    }

    @Test
    public void testCreateExistingUser() {
        UserCreationRequest request = Mockito.mock(UserCreationRequest.class);
        Mockito.when(request.getUsername()).thenReturn(TEST_USERNAME);

        assertThrows(UserExistsException.class, () -> userService.createUser(request));
    }

    @Test
    public void testCreateUser() {
        Mockito.when(user.getUsername()).thenReturn(EMPTY_USERNAME);

        UserCreationRequest request = Mockito.mock(UserCreationRequest.class);
        Mockito.when(request.getUsername()).thenReturn(EMPTY_USERNAME);
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        UserDto result = userService.createUser(request);

        assertNotNull(result);
        assertEquals(EMPTY_USERNAME, result.getUsername());
    }
}
