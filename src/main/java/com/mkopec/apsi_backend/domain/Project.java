package com.mkopec.apsi_backend.domain;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
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

    @Column(name = "is_archived",columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean isArchived;

    @OneToOne
    @JoinColumn(name = "project_leader", referencedColumnName = "id")
    private Person projectLeader;

    @ManyToMany(mappedBy = "projects")
    private List<Person> persons;

    @OneToMany(mappedBy = "project", fetch = LAZY, cascade = ALL, orphanRemoval = true)
    private List<Report> reports;
}
