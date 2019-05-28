package com.mkopec.apsi_backend.auth.repository;

import com.mkopec.apsi_backend.auth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
