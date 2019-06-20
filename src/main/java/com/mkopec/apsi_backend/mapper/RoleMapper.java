package com.mkopec.apsi_backend.mapper;

import com.google.common.base.CaseFormat;
import com.mkopec.apsi_backend.domain.RoleInClub;
import com.mkopec.apsi_backend.dtos.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class RoleMapper {

    @Mapping(target = "organizationStatus", expression = "java(getRoleName(roleInClub))")
    public abstract RoleDTO toRoleDTO(RoleInClub roleInClub);

    public abstract List<RoleDTO> toRoleDTOs(List<RoleInClub> roleInClubList);

    protected String getRoleName(RoleInClub roleInClub) {
        return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, roleInClub.getName().name());
    }
}
