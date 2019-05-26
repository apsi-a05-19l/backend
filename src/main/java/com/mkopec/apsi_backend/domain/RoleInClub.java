package com.mkopec.apsi_backend.domain;

import com.mkopec.apsi_backend.enums.RoleType;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "RoleInClub")
public class RoleInClub {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private RoleType name;
}
