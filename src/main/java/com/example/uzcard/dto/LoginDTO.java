package com.example.uzcard.dto;

import com.example.uzcard.enums.GeneralRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginDTO {
    private String username;
    private GeneralRole role;
    private String jwt;
}
