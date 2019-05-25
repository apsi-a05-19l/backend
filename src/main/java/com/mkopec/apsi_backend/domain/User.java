package com.mkopec.apsi_backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
