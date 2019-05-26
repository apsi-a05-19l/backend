package com.mkopec.apsi_backend.dtos;

import lombok.Data;

import java.util.List;

@Data
public class FullProjectDTO {

    private Integer id;

    private String name;

    private String currentLeader;

    private List<ReportDTO> reports;

    private List<SimplePersonDTO> members;
}
