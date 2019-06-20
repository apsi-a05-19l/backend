package com.mkopec.apsi_backend.dtos;

import lombok.Data;

@Data
public class ProjectPostDTO {
    private Integer id;
    private Integer leaderId;
    private String name;
}
