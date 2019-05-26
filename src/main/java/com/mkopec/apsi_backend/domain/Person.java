package com.mkopec.apsi_backend.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phone_number;

    private String email;

    @Column(name = "date_from")
    private java.util.Calendar dateFrom;

    @ManyToOne
    @JoinColumn(name = "RoleinClub_id")
    private RoleInClub roleInClub;

    private Integer points;

    @OneToMany(cascade = ALL, mappedBy = "person", fetch = LAZY)
    private List<Activity> activities;

    @ManyToMany
    @JoinTable(
            name = "Persons_Projects",
            joinColumns = @JoinColumn(name = "Person_id"),
            inverseJoinColumns = @JoinColumn(name = "Project_id")
    )
    private List<Project> projects;
}
