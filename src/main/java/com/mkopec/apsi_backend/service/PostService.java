package com.mkopec.apsi_backend.service;


import com.mkopec.apsi_backend.domain.Person;
import com.mkopec.apsi_backend.repository.PersonRepository;
import com.mkopec.apsi_backend.service.PersonService;
import com.mkopec.apsi_backend.domain.Post;
import com.mkopec.apsi_backend.enums.PostTopic;
import com.mkopec.apsi_backend.exception.ResourceNotFoundException;
import com.mkopec.apsi_backend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;
    private final PersonService personService;
    private final PersonRepository personRepository;

    public Post getSinglePost(Integer id) {
        return repository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Post", "id", id));
    }

    public List<Post> getAllPosts() {return repository.findAll();}

    @Transactional
    public Post postPost(Post post, Integer member_id) {
        Person person = personRepository.getOne(member_id);
        post.setAuthor(person);
        post.setParts(new ArrayList<>());
        post.setTitle(post.getTitle());
        post.setTopic(PostTopic.PROGRAMMING.toString()); // TODO: change from hardcoded
        Post savedPost = repository.save(post);
        return savedPost;
    }

    public void deletePost(Integer id) {repository.deleteById(id);}

}
