package com.mkopec.apsi_backend.mapper;

import com.mkopec.apsi_backend.domain.Post;
import com.mkopec.apsi_backend.dtos.FullPostDTO;
import com.mkopec.apsi_backend.dtos.ShortPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PartMapper.class})
public abstract class PostMapper {

    @Mapping(target = "postTopic", source = "topic")
    public abstract ShortPostDTO toShortPostDTO(Post post);

    public abstract List<ShortPostDTO> toShortPostDTOs(List<Post> posts);

    public abstract FullPostDTO toFullPostDTO(Post post);

    public abstract Post toPost(FullPostDTO postDTO);
}
