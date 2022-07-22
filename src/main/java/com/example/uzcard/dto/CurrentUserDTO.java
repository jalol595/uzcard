package com.example.uzcard.dto;


import com.example.uzcard.enums.GeneralRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrentUserDTO {
    private String id;
    private String username;
    private GeneralRole role;
}
