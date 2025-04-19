package com.example.petprojectgeneralinfoservice.data.dto;

import com.example.petprojectgeneralinfoservice.data.entity.Contact;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ContactDto {

    private String value;
    private String typeDescription;
    private String typeIco;

    public static ContactDto fromEntity(Contact contact) {
        return ContactDto.builder()
                .value(contact.getValue())
                .typeDescription(contact.getType().getDescription())
                .typeIco(contact.getType().getIco())
                .build();
    }
}
