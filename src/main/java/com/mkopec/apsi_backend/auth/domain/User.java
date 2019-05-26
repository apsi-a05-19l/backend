package com.mkopec.apsi_backend.auth.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "User")
public class User {
    @Column(name = "Person_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    private String authority;
}