package com.mkopec.apsi_backend.service;

import com.mkopec.apsi_backend.domain.Part;
import com.mkopec.apsi_backend.exception.ResourceNotFoundException;
import com.mkopec.apsi_backend.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PartService {
    private final PartRepository repository;

    public List<Part> getAllParts() {return repository.findAll();}

    public Part getSinglePart(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Part", "id", id));
    }

    public Part postPart(Part part) {
        part.setHeader(part.getHeader());
        part.setContents(part.getContents());
        part.setLinks(new ArrayList<>());
        Part savedPart = repository.save(part);
        return savedPart;
    }
}
