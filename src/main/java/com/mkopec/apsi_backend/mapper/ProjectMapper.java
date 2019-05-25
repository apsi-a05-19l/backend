package com.mkopec.apsi_backend.mapper;

import com.mkopec.apsi_backend.domain.Project;
import com.mkopec.apsi_backend.dtos.ShortProjectDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class ProjectMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "id")
    public abstract ShortProjectDTO toShortProjectDTO(Project project);
}
