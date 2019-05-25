package com.mkopec.apsi_backend.dtos;

import com.mkopec.apsi_backend.domain.Activity;
import com.mkopec.apsi_backend.enums.RoleType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonDTO {
    private Integer id;

    private String firstName;

    private String lastName;

    private String phone_number;

    private String email;

    private java.util.Calendar dateFrom;

    private RoleType roleInClub;

    private List<ActivityDTO> activities;
}
