package com.example.petprojectgeneralinfoservice.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "passowrd", nullable = false)
    private String password;

    @Column(name = "bio")
    private String bio;

    @Column(name = "active", nullable = false)
    private boolean active;
}
