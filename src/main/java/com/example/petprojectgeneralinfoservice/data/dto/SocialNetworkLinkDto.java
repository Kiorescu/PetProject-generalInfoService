package com.example.petprojectgeneralinfoservice.data.dto;

import com.example.petprojectgeneralinfoservice.data.entity.SocialNetworkLink;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SocialNetworkLinkDto {

    private String link;
    private SocialNetworkDto socialNetwork;

    public static SocialNetworkLinkDto fromEntity(SocialNetworkLink socialNetworkLink) {
        return SocialNetworkLinkDto.builder()
                .link(socialNetworkLink.getLink())
                .socialNetwork(SocialNetworkDto.fromEntity(socialNetworkLink.getId().getSocialNetwork()))
                .build();
    }
}
