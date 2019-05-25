package com.mkopec.apsi_backend.dtos;

import com.mkopec.apsi_backend.enums.RoleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShortPersonDTO {
    private Integer id;
    private String name;
    private String surname;
    private RoleType organizationStatus;
    private Integer points;
}
