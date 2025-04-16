package com.example.petprojectgeneralinfoservice.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreationRequest {

    private String name;
    private String username;
    private String password;

}
