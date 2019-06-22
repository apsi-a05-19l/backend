package com.mkopec.apsi_backend.domain;

import lombok.Data;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table (name = "Post")
public class Post {

    @Id
    @GeneratedValue (strategy = IDENTITY)
    private Integer id;

    private String title;

    private Integer authorId;

    private String topic;

    @OneToMany(cascade = ALL, orphanRemoval = true)
    private List<Part> parts;
}
