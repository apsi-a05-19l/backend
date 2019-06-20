package com.mkopec.apsi_backend.repository;

import com.mkopec.apsi_backend.domain.PersonsProjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonsProjectsRepository extends JpaRepository<PersonsProjects, Long> {

    void deleteByProjectIDAndPersonID(Integer projectID, Integer personID);

    void deleteAllByProjectID(Integer projectID);

    @Modifying
    @Query("DELETE FROM PersonsProjects p WHERE p.personID = ?1")
    void deleteAllByPersonID(Integer personID);
}
