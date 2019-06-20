package com.mkopec.apsi_backend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Persons_Projects")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonsProjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Person_id")
    private Integer personID;

    @Column(name = "Project_id")
    private Integer projectID;

    @Column(name = "date_from")
    private java.util.Calendar dateFrom;
}
