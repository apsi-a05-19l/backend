package com.mkopec.apsi_backend.mapper;

import com.mkopec.apsi_backend.domain.Part;
import com.mkopec.apsi_backend.domain.Post;
import com.mkopec.apsi_backend.dtos.FullPartDTO;
import com.mkopec.apsi_backend.dtos.FullPostDTO;
import com.mkopec.apsi_backend.dtos.ShortPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PostMapper {

    @Autowired
    protected PartMapper partMapper;

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "postTopic", source = "topic")
    public abstract ShortPostDTO toShortPostDTO(Post post);

    public abstract List<ShortPostDTO> toShortPostDTOs(List<Post> posts);

    @Mapping(target = "parts", source = "java(partMapper.toPartDTO(post.getParts())")
    public abstract FullPostDTO toFullPostDTO(Post post);

    public abstract Post toPost(FullPostDTO postDTO);

    @Mapping(target = "links", source = "java(linkMapper.toLinkDTO(part.getLinks())")
    public abstract Part toPart (FullPartDTO partDTO);

}
