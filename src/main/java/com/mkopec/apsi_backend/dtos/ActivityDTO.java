package com.mkopec.apsi_backend.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActivityDTO {
    private Integer id;

    private java.util.Calendar date;

    private Integer points;

    private String name;

    private Integer idPerson;
    //public PersonDTO person;
}
