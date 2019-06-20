package com.mkopec.apsi_backend.service;


import com.mkopec.apsi_backend.domain.Post;
import com.mkopec.apsi_backend.exception.ResourceNotFoundException;
import com.mkopec.apsi_backend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;

    public Post getSinglePost(Integer id) {
        return repository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Post", "id", id));
    }

    public List<Post> getAllPosts() {return repository.findAll();}

    public void deletePost(Integer id) {repository.deleteById(id);}

    public Post postPost(Post post) {return repository.save(post);}
}
