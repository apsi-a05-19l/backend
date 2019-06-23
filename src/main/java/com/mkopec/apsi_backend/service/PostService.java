package com.mkopec.apsi_backend.service;


import com.mkopec.apsi_backend.domain.Link;
import com.mkopec.apsi_backend.domain.Part;
import com.mkopec.apsi_backend.domain.Post;
import com.mkopec.apsi_backend.exception.ResourceNotFoundException;
import com.mkopec.apsi_backend.repository.LinkRepository;
import com.mkopec.apsi_backend.repository.PartRepository;
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
    private final PartRepository partRepository;
    private final LinkRepository linkRepository;

    public Post getSinglePost(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
    }

    public List<Post> getAllPosts() {return repository.findAll();}

    @Transactional
    public Post postPost(Post post) {
        List<Part> parts = post.getParts();
        post.setParts(null);
        Post newPost = repository.save(post);
        newPost.setParts(savePostParts(parts, newPost));
        return repository.save(newPost);
    }

    private List<Part> savePostParts(List<Part> parts, Post newPost) {
        List<Part> newParts = new ArrayList<>();
        parts.forEach(part -> {
            part.setPost(newPost);
            List<Link> links = part.getLinks();
            part.setLinks(null);
            Part newPart = partRepository.save(part);
            links.forEach(link -> link.setPart(newPart));
            newPart.setLinks(linkRepository.saveAll(links));
            newParts.add(partRepository.save(newPart));
        });
        return newParts;
    }

    public void deletePost(Integer id) {repository.deleteById(id);}

}
