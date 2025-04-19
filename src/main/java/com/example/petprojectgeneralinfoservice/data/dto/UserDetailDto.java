package com.example.petprojectgeneralinfoservice.data.dto;

import com.example.petprojectgeneralinfoservice.data.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UserDetailDto {

    private String name;
    private String username;
    private String bio;
    private List<ContactDto> contacts;
    private List<UserLanguageDto> languages;
    private List<SocialNetworkLinkDto> socialNetworkLinks;

    public static UserDetailDto fromUser(User user) {
        return UserDetailDto.builder()
                .name(user.getName())
                .username(user.getUsername())
                .bio(user.getBio())
                .contacts(user.getContacts().stream().map(ContactDto::fromEntity).toList())
                .languages(user.getUserLanguages().stream().map(UserLanguageDto::fromEntity).toList())
                .socialNetworkLinks(user.getSocialNetworkLinks().stream().map(SocialNetworkLinkDto::fromEntity).toList())
                .build();


    }
}

