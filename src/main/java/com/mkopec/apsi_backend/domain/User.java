package com.mkopec.apsi_backend.domain;

import lombok.Data;

import javax.persistence.*;

@Table(name = "User")
@Entity
@Data
public class User {

    @Id
    @Column(name = "Person_idPerson")
    private Integer idUser;

    private String login;

    private String password;
}
