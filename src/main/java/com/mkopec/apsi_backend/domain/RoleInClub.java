package com.mkopec.apsi_backend.domain;

import com.mkopec.apsi_backend.enums.RoleType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "RoleInClub")
public class RoleInClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public RoleType getName() {
        return name;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private RoleType name;
}
