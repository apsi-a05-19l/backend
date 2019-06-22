package com.mkopec.apsi_backend.dtos;

import com.mkopec.apsi_backend.enums.PostTopic;
import lombok.Data;

import java.util.List;

@Data
public class FullPostDTO {

    private Integer id;

    private String title;

    private Integer authorId;

    private PostTopic postTopic;

    private List<FullPartDTO> parts;
}
