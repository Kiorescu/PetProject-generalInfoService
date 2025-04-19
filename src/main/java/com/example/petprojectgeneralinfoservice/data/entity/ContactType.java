package com.example.petprojectgeneralinfoservice.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "contact_type")
public class ContactType {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "ico", nullable = false)
    private String ico;
}
