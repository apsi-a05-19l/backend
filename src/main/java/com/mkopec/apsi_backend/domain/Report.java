package com.mkopec.apsi_backend.domain;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "Report")
public class Report {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String content;

    @Basic
    @Temporal(TemporalType.DATE)
    private java.util.Calendar date;

    @ManyToOne
    @JoinColumn(name = "Project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "Person_id")
    private Person person;
}
