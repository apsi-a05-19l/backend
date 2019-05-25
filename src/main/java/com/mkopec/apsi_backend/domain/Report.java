package com.mkopec.apsi_backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Report")
public class Report {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    @Basic
    @Temporal(TemporalType.DATE)
    private java.util.Calendar date;

    @ManyToOne
    @JoinColumn(name = "Project_id")
    private Project project;
}
