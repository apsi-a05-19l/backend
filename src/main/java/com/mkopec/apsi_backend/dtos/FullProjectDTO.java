package com.mkopec.apsi_backend.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FullProjectDTO {

    private Integer id;

    private String name;

    private String currentLeader;

    private List<ReportDTO> reports;

    private List<SimplePersonDTO> members;
}
