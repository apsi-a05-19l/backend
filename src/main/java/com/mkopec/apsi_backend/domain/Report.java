package com.mkopec.apsi_backend.domain;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.LAZY;
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

    @ManyToOne(cascade = {MERGE, PERSIST, DETACH, REFRESH}, fetch = LAZY)
    @JoinColumn(name = "Person_id")
    private Person person;
}
