package com.mkopec.apsi_backend.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "User")
@Entity
@Setter
@Getter
public class User {

    @Id
    @Column(name = "Person_id")
    private Integer idUser;

    private String login;

    private String password;
}
