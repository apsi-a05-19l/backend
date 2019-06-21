package com.mkopec.apsi_backend.dtos;

import com.mkopec.apsi_backend.domain.Person;
import com.mkopec.apsi_backend.enums.PostTopic;
import lombok.Data;

import java.util.List;

@Data
public class FullPostDTO {

    private Integer id;

    private String title;

    private Person author;

    private PostTopic postTopic;

    private List<PartDTO> parts;
}
