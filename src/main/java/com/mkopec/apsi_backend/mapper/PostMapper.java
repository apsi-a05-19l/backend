package com.mkopec.apsi_backend.mapper;

import com.mkopec.apsi_backend.domain.Post;
import com.mkopec.apsi_backend.dtos.ShortPostDTO;
import com.mkopec.apsi_backend.enums.PostTopic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PostMapper {

    @Autowired
    protected PostMapper postMapper;

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "postTopic", source = "topic")
    public abstract ShortPostDTO toShortPostDTO(Post post);

    public abstract List<ShortPostDTO> toShortPostDTOs(List<Post> posts);
}
