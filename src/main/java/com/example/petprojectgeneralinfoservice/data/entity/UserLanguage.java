package com.example.petprojectgeneralinfoservice.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_language")
public class UserLanguage {

    @EmbeddedId
    private UserLanguageId id;

    @Column(name = "level", nullable = false)
    private String level;

    @Embeddable
    public static class UserLanguageId {

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        private User user;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "language_id")
        private Language language;
    }
}
