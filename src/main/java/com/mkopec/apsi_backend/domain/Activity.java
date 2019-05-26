package com.mkopec.apsi_backend.domain;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "Activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Basic
    @Temporal(TemporalType.DATE)
    private java.util.Calendar date;

    private Integer points;

    private String name;

    @Column(name = "ActivityTag_id")
    private Integer activityTagId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "Person_id")
    private Person person;
}
