package com.example.uzcard.entity;

import com.example.uzcard.enums.CardStatus;
import com.example.uzcard.enums.GeneralRole;
import com.example.uzcard.enums.GeneralStatus;
import com.example.uzcard.enums.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "company")
@NoArgsConstructor
public class CompanyEntity extends BaseEntity{

    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String contact;
    @Column
    @Enumerated(EnumType.STRING)
    private GeneralRole role;
    @Column
    @Enumerated(EnumType.STRING)
    private GeneralStatus status = GeneralStatus.ACTIVE;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column() // nullable = false
    private Double servicePercentage;

    @Column(name = "card_id")
    private String cardId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", updatable = false, insertable = false)
    private CardEntity cardEntity;

}
