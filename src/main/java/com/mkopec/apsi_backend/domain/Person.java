package com.mkopec.apsi_backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "Person")
@Entity
@Setter
@Getter
public class Person {

    @Column(name = "id")
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

    @ManyToOne
    @JoinColumn(name = "RoleinClub_id")
    private RoleInClub roleInClub;

    @Column(name = "points")
    private Integer points;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person", fetch = FetchType.LAZY)
    private List<Activity> activities;

    @ManyToMany
    @JoinTable(
            name = "Persons_Projects",
            joinColumns = @JoinColumn(name = "Person_id"),
            inverseJoinColumns = @JoinColumn(name = "Project_id")
    )
    private List<Project> projects;
}
