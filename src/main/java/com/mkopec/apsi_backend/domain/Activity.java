package com.mkopec.apsi_backend.domain;

import lombok.Data;

import javax.persistence.*;

@Table(name = "Activity")
@Entity
@Data
public class Activity {

    @Column(name = "idActivity")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    @Basic
    @Temporal(TemporalType.DATE)
    private java.util.Calendar date;

    @Column(name = "points")
    private Integer points;

    @Column(name = "ActivityTag_name")
    private String name;

    @Column(name = "Person_idPerson")
    private Integer personID;

}
