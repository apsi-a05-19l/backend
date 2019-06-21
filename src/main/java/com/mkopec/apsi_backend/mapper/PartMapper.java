package com.mkopec.apsi_backend.mapper;

import com.mkopec.apsi_backend.domain.Part;
import com.mkopec.apsi_backend.dtos.FullPartDTO;
import com.mkopec.apsi_backend.dtos.ShortPartDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper (componentModel = "spring")
public abstract class PartMapper {

    @Autowired
    protected LinkMapper linkMapper;

    @Mapping(target = "id", source = "id")
    @Mapping(target = "header", source = "header")
    public abstract ShortPartDTO toShortPartDTO (Part part);

    public abstract List<ShortPartDTO> toShortPartDTOS(List<Part> parts);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "header", source = "header")
    @Mapping(target = "contents", source = "contents")
    @Mapping(target = "links", source = "java(linkMapper.toLinkDTO(part.getLinks())")
    public abstract FullPartDTO toFullPartDTO (Part part);

    public abstract Part toPart(FullPartDTO fullPartDTO);

}
