package com.mkopec.apsi_backend.dtos;

import lombok.Data;

@Data
public class PersonPostDTO {
    private Integer id;
    private String name;
    private String surname;
    private String phone_number;
    private String email;
    private Integer roleID;
}
