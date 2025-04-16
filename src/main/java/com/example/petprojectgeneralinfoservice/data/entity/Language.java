package com.example.petprojectgeneralinfoservice.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "language")
public class Language {

    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
}
