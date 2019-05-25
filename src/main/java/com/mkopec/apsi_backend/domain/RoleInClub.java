package com.mkopec.apsi_backend.domain;

import com.mkopec.apsi_backend.enums.RoleType;
import lombok.Data;

import javax.persistence.*;

@Data
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
