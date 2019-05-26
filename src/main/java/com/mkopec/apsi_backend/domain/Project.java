package com.mkopec.apsi_backend.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "Project")
public class Project {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "date_from")
    @Basic
    @Temporal(TemporalType.DATE)
    private java.util.Calendar date;

    private String name;

    @OneToOne
    @JoinColumn(name = "project_leader", referencedColumnName = "id")
    private Person projectLeader;

    @ManyToMany(mappedBy = "projects")
    private List<Person> persons;

    @OneToMany(mappedBy = "project")
    private List<Report> reports;
}
