package com.mkopec.apsi_backend.repository;

import com.mkopec.apsi_backend.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findAllByAuthorId(Integer authorID);
}
