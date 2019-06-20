package com.mkopec.apsi_backend.service;

import com.mkopec.apsi_backend.domain.RoleInClub;
import com.mkopec.apsi_backend.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository repository;

    public List<RoleInClub> getAllRoles() {
        return repository.findAll();
    }
}
