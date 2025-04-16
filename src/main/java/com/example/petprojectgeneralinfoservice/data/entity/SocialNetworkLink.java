package com.example.petprojectgeneralinfoservice.data.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "social_network_link")
public class SocialNetworkLink {

    @EmbeddedId
    private SocialNetworkLinkId id;

    @Column(name = "link", nullable = false)
    private String link;

    @Embeddable
    public static class SocialNetworkLinkId {

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        private User user;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "social_network_id")
        private SocialNetwork socialNetwork;
    }
}
