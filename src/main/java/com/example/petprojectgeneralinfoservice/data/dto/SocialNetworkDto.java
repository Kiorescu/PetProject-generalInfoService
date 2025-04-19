package com.example.petprojectgeneralinfoservice.data.dto;

import com.example.petprojectgeneralinfoservice.data.entity.SocialNetwork;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SocialNetworkDto {

    private String name;
    private String ico;

    public static SocialNetworkDto fromEntity(SocialNetwork socialNetwork) {
        return SocialNetworkDto.builder()
                .name(socialNetwork.getName())
                .ico(socialNetwork.getIco())
                .build();
    }
}
