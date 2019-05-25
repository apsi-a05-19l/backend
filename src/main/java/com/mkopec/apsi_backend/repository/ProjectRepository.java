package com.mkopec.apsi_backend.repository;

import com.mkopec.apsi_backend.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
