package com.mkopec.apsi_backend.repository;

import com.mkopec.apsi_backend.domain.RoleInClub;
import com.mkopec.apsi_backend.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleInClub, Integer> {
    RoleInClub findByName(RoleType roleType);
}
