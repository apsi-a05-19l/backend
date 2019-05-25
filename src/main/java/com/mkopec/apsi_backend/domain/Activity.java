package com.mkopec.apsi_backend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "Activity")
@Entity
@Setter
@Getter
public class Activity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    @Basic
    @Temporal(TemporalType.DATE)
    private java.util.Calendar date;

    @Column(name = "points")
    private Integer points;

    @Column(name = "name")
    private String name;

    @Column(name = "ActivityTag_id")
    private Integer activityTagId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Person_id")
    private Person person;
}
