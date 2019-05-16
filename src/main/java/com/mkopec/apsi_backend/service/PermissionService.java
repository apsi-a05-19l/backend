package com.mkopec.apsi_backend.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {

    public boolean hasPermission(Long userId, String endpoint) {


        return true;
    }
}
