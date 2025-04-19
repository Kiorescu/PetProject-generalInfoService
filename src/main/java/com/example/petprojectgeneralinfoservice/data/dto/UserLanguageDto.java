package com.example.petprojectgeneralinfoservice.data.dto;

import com.example.petprojectgeneralinfoservice.data.entity.UserLanguage;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserLanguageDto {

    private String language;
    private String level;

    public static UserLanguageDto fromEntity(UserLanguage userLanguage) {
        return UserLanguageDto.builder()
                .language(userLanguage.getId().getLanguage().getName())
                .level(userLanguage.getLevel())
                .build();
    }
}
