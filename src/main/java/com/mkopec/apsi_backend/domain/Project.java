package com.mkopec.apsi_backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Project")
public class Project {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_from")
    @Basic
    @Temporal(TemporalType.DATE)
    private java.util.Calendar date;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "project_leader", referencedColumnName = "id")
    private Person projectLeader;

    @ManyToMany(mappedBy = "projects")
    private List<Person> persons;

    @OneToMany(mappedBy = "project")
    private List<Report> reports;
}
