package com.mkopec.apsi_backend.repository;

import com.mkopec.apsi_backend.domain.PersonsProjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonsProjectsRepository extends JpaRepository<PersonsProjects, Long> {

    void deleteByProjectIDAndPersonID(Integer projectID, Integer personID);

    void deleteAllByProjectID(Integer projectID);
}
