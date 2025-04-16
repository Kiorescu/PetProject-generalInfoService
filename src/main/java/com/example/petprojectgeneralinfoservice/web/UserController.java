package com.example.petprojectgeneralinfoservice.web;

import com.example.petprojectgeneralinfoservice.data.dto.UserCreationRequest;
import com.example.petprojectgeneralinfoservice.data.dto.UserDto;
import com.example.petprojectgeneralinfoservice.service.UserService;
import com.example.petprojectgeneralinfoservice.util.exceptions.UserExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> findByUsername(@PathVariable("username") String username) {
        return userService.findByUsername(username).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserCreationRequest user) {
        try {
            return ResponseEntity.ok(userService.createUser(user));
        } catch (UserExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
