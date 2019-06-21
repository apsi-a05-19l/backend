package com.mkopec.apsi_backend.dtos;

import lombok.Data;

@Data
public class ShortPersonDTO {
    private Integer id;
    private String name;
    private String surname;
    private String organisationStatus;
    private Integer points;
}
