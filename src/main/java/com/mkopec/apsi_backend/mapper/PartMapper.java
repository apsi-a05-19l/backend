package com.mkopec.apsi_backend.mapper;

import com.mkopec.apsi_backend.domain.Part;
import com.mkopec.apsi_backend.dtos.PartDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper (componentModel = "spring")
public abstract class PartMapper {

    public abstract PartDTO toPartDTO (Part part);

    public abstract List<PartDTO> toPartDTOS(List<Part> parts);

}
