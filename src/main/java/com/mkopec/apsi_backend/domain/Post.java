package com.mkopec.apsi_backend.domain;

import com.mkopec.apsi_backend.enums.PostTopic;
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

    @Enumerated(EnumType.STRING)
    private PostTopic topic;

    @OneToMany(cascade = ALL, orphanRemoval = true)
    private List<Part> parts;
}
