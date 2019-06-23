package com.mkopec.apsi_backend.dtos;

import lombok.Data;

import java.util.List;

@Data
public class FullPartDTO {
    private Integer id;

    private String header;

    private String contents;

    private List<LinkDTO> links;

    private Integer post_id;
}
