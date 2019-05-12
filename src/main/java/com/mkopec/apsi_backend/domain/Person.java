package com.mkopec.apsi_backend.domain;

import lombok.Data;

import javax.persistence.*;

@Table(name = "Person")
@Entity
public class Person {

    @Column(name = "idPerson")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "email")
    private String email;

    @Column(name = "date_from")
    private java.util.Calendar dateFrom;

    @Column(name = "RoleInClub_name")
    private String roleInClub;
}
