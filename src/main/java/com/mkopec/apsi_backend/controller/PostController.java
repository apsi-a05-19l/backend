package com.mkopec.apsi_backend.controller;


import com.mkopec.apsi_backend.domain.Part;
import com.mkopec.apsi_backend.domain.Post;
import com.mkopec.apsi_backend.dtos.FullPartDTO;
import com.mkopec.apsi_backend.dtos.FullPostDTO;
import com.mkopec.apsi_backend.dtos.ShortPostDTO;
import com.mkopec.apsi_backend.mapper.PostMapper;
import com.mkopec.apsi_backend.service.PartService;
import com.mkopec.apsi_backend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final PostMapper mapper;
    private final PartService partService;

    @GetMapping()
    public List<ShortPostDTO> getAllPosts() {
        return mapper.toShortPostDTOs (postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public FullPostDTO getSinglePost(@PathVariable Integer id) {
        return mapper.toFullPostDTO (postService.getSinglePost(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public FullPostDTO postPost (@RequestBody FullPostDTO fullPostDTO, @PathVariable Integer memberId) {
     Post post = mapper.toPost(fullPostDTO);
     List<Part> parts = partService.getAllParts(post.getParts());
     post.setParts(parts);
     return mapper.toFullPostDTO(postService.postPost(post, memberId));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deletePost(@PathVariable Integer id) { postService.deletePost(id); }
}
