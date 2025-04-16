package com.example.petprojectgeneralinfoservice.data.dto;

import com.example.petprojectgeneralinfoservice.data.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {

    private String name;
    private String username;
    private String bio;

    public static UserDto fromUser(User user) {
        return UserDto.builder()
                .name(user.getName())
                .username(user.getUsername())
                .bio(user.getBio())
                .build();
    }
}
