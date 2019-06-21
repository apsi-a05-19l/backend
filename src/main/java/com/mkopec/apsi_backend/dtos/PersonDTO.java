package com.mkopec.apsi_backend.dtos;

import lombok.Data;

import java.util.List;

@Data
public class PersonDTO {
    private Integer id;
    private String name;
    private String surname;
    private String phone_number;
    private String email;
    private Integer roleID;
    private String organisationStatus;
    private Integer points;
    private List<ShortProjectDTO> projects;
    private List<ActivityDTO> activities;
}
