package com.mkopec.apsi_backend.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportPostDTO {

    private Integer id;

    private String text;

    private String author;

    private Integer projectID;
}
