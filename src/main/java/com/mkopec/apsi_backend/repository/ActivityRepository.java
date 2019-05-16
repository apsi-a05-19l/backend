package com.mkopec.apsi_backend.repository;

import com.mkopec.apsi_backend.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}
