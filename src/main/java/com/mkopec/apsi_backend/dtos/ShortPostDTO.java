package com.mkopec.apsi_backend.dtos;

import com.mkopec.apsi_backend.enums.PostTopic;
import lombok.Data;

@Data
public class ShortPostDTO {
    private Integer id;
    private String title;
    private PostTopic postTopic;
}
