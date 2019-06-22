package com.mkopec.apsi_backend.domain;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table (name = "Link")
public class Link {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private int order_number;

    private String source;

    @ManyToOne
    @JoinColumn(name = "Part_id", referencedColumnName = "id")
    private Part part;

}
