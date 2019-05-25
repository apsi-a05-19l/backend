package com.mkopec.apsi_backend.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActivityPostDTO {

    private Integer id;

    private String activityName;

    private Integer activityPoints;
}
