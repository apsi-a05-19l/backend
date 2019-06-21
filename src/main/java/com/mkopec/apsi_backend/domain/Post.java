package com.mkopec.apsi_backend.domain;

import lombok.Data;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table (name = "Post")
public class Post {

    @Id
    @GeneratedValue (strategy = IDENTITY)
    private Integer id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "id")
    private Person author;

    private String topic;

    @OneToMany
    private List<Part> parts;
}
