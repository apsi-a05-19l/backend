package com.mkopec.apsi_backend.service;

import com.mkopec.apsi_backend.domain.Link;
import com.mkopec.apsi_backend.domain.Part;
import com.mkopec.apsi_backend.exception.ResourceNotFoundException;
import com.mkopec.apsi_backend.repository.LinkRepository;
import com.mkopec.apsi_backend.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Service
@RequiredArgsConstructor
public class LinkService {
    private final LinkRepository repository;
    private final PartRepository partRepository;

    public List<Link> getAllLinks(List<Link> parts) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("post_id")
                .withMatcher("id", ignoreCase())
                .withMatcher("header", ignoreCase())
                .withMatcher("contents", ignoreCase())
                .withMatcher("links", ignoreCase());
        Example<List<Link>> example = Example.of(parts, matcher);

        if (repository.exists(example)) {
            return repository.findOne(example).orElseThrow(() -> new ResourceNotFoundException("Part", "ByExample", parts));
        } else {
            return repository.save(parts);
        }
    }

    public Link postLink (Link link, Integer partId) {
        Part part = partRepository.getOne(partId);
        link.setPart_id(part);
        link.setOrder_number(link.getOrder_number());
        link.setSource(link.getSource());
        Link savedLink = repository.save(link);
        return savedLink;
    }
}
