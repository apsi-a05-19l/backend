package com.mkopec.apsi_backend.service;

import com.mkopec.apsi_backend.domain.Part;
import com.mkopec.apsi_backend.domain.Post;
import com.mkopec.apsi_backend.exception.ResourceNotFoundException;
import com.mkopec.apsi_backend.repository.PartRepository;
import com.mkopec.apsi_backend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Service
@RequiredArgsConstructor
public class PartService {
    private final PartRepository repository;
    private final PostRepository postRepository;

    public List<Part> getAllParts(List<Part> parts) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("post_id")
                .withMatcher("id", ignoreCase())
                .withMatcher("header", ignoreCase())
                .withMatcher("contents", ignoreCase())
                .withMatcher("links", ignoreCase());
        Example<List<Part>> example = Example.of(parts, matcher);

        if (repository.exists(example)) {
            return repository.findOne(example).orElseThrow(() -> new ResourceNotFoundException("Part", "ByExample", parts));
        } else {
            return repository.save(parts);
        }
    }

    public Part getSinglePart(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Part", "id", id));
    }

    public Part postPart(Part part, Integer postId) {
        Post post = postRepository.getOne(postId);
        part.setPost_id(post);
        part.setHeader(part.getHeader());
        part.setContents(part.getContents());
        part.setLinks(new ArrayList<>());
        Part savedPart = repository.save(part);
        return savedPart;
    }
}
