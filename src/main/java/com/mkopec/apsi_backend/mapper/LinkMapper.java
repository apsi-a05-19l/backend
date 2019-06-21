package com.mkopec.apsi_backend.mapper;

import com.mkopec.apsi_backend.domain.Link;
import com.mkopec.apsi_backend.dtos.LinkDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class LinkMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "order_number", source = "order_number")
    @Mapping(target = "source", source = "source")
    public abstract LinkDTO toLinkDTO (Link link);

    public abstract Link toLink(LinkDTO linkDTO);
}
