package com.mkopec.apsi_backend.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Activity")
@Data
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    @Basic
    @Temporal(TemporalType.DATE)
    private java.util.Calendar date;

    @Column(name = "points")
    private Integer points;

    @Column(name = "ActivityTag_name")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "name")
    private String name;

    @Column(name = "Person_idPerson")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "name")
    private Person person;
}
