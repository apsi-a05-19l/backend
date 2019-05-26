package com.mkopec.apsi_backend.dtos;

import com.mkopec.apsi_backend.enums.RoleType;
import lombok.Data;

import java.util.List;

@Data
public class PersonDTO {
    private Integer id;

    private String name;

    private String surname;

    private RoleType organizationStatus;

    private Integer points;

    private List<ShortProjectDTO> projects;

    private List<ActivityDTO> activities;
}
