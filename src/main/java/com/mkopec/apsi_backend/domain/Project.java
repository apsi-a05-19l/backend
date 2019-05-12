package com.mkopec.apsi_backend.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Project")
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



}
