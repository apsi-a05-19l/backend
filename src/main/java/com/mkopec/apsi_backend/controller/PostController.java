package com.mkopec.apsi_backend.controller;


import com.mkopec.apsi_backend.dtos.ShortPostDTO;
import com.mkopec.apsi_backend.mapper.PostMapper;
import com.mkopec.apsi_backend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final PostMapper mapper;

    @GetMapping()
    public List<ShortPostDTO> getAllPosts() {
        return mapper.toShortPostDTOs (postService.getAllPosts());
    }

    // @GetMapping("/{id}")
    // public FullPostDTO

}
