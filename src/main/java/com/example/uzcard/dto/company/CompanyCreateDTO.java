package com.example.uzcard.dto.company;

import com.example.uzcard.entity.CardEntity;
import com.example.uzcard.entity.CompanyEntity;
import com.example.uzcard.enums.GeneralRole;
import com.example.uzcard.enums.GeneralStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Setter
@Getter
public class CompanyCreateDTO {

    private String id;
    private String name;
    private String address;
    private String contact;
    private String username;
    private String password;


    private Double servicePercentage;
    private String cardId;

    private GeneralRole role;

}
