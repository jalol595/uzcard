package com.example.uzcard.entity;

import com.example.uzcard.enums.GeneralRole;
import com.example.uzcard.enums.GeneralStatus;
import com.example.uzcard.enums.ProfileStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "profile")
@NoArgsConstructor
public class ProfileEntity extends BaseEntity{



    @Column(nullable = false)
    private String name;
    @Column(name = "surname")
    private String surname;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private GeneralRole role;

    @Column
    @Enumerated(EnumType.STRING)
    private GeneralStatus status = GeneralStatus.ACTIVE;

}
