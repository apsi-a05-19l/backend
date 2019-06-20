package com.mkopec.apsi_backend.domain;

import lombok.Data;

import javax.persistence.*;

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
    private Post post_id;
}
