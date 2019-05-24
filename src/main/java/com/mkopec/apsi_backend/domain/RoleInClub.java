package com.mkopec.apsi_backend.domain;

import com.mkopec.apsi_backend.enums.RoleType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "RoleInClub" )
public class RoleInClub {
    @Id
    @Enumerated(EnumType.STRING)
    private RoleType name;
}
