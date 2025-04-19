package com.example.petprojectgeneralinfoservice.data.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "social_network")
public class SocialNetwork {

    @Id
    private Long id;

    @Column(name = "ico", nullable = false)
    private String ico;

    @Column(name = "name", nullable = false)
    private String name;
}
