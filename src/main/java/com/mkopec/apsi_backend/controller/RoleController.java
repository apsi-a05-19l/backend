package com.mkopec.apsi_backend.controller;

import com.mkopec.apsi_backend.dtos.RoleDTO;
import com.mkopec.apsi_backend.mapper.RoleMapper;
import com.mkopec.apsi_backend.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {
    private final RoleService service;
    private final RoleMapper mapper;

    @GetMapping
    public List<RoleDTO> getAllRoles(){
        return mapper.toRoleDTOs(service.getAllRoles());
    }
}
