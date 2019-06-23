package com.mkopec.apsi_backend.domain;

import lombok.Data;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "Part")
public class Part {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String header;

    private String contents;

    @ManyToOne
    @JoinColumn(name = "Post_id", referencedColumnName = "id")
    private Post post;

    @OneToMany(cascade = ALL, orphanRemoval = true, mappedBy = "part", fetch = LAZY)
    private List<Link> links;
}
