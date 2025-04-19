package com.example.petprojectgeneralinfoservice.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "bio")
    private String bio;

    @Column(name = "active", nullable = false)
    private boolean active;

    @OneToMany(mappedBy = "user")
    private Set<Contact> contacts;

    @OneToMany(mappedBy = "id.user")
    private Set<UserLanguage> userLanguages;

    @OneToMany(mappedBy = "id.user")
    private Set<SocialNetworkLink> socialNetworkLinks;
}
