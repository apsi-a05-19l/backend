package com.mkopec.apsi_backend.mapper;

import com.mkopec.apsi_backend.domain.Part;
import com.mkopec.apsi_backend.dtos.FullPartDTO;
import com.mkopec.apsi_backend.dtos.ShortPartDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper (componentModel = "spring", uses = {LinkMapper.class})
public abstract class PartMapper {

    @Mapping(target = "post_id", source = "post.id")
    public abstract ShortPartDTO toShortPartDTO (Part part);

    public abstract List<ShortPartDTO> toShortPartDTOS(List<Part> parts);

    @Mapping(target = "post_id", source = "post.id")
    public abstract FullPartDTO toFullPartDTO (Part part);

    public abstract Part toPart(FullPartDTO fullPartDTO);

}
