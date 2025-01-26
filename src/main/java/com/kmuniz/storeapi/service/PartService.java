package com.kmuniz.storeapi.service;

import com.kmuniz.storeapi.domain.PartRepository;
import com.kmuniz.storeapi.domain.entity.Part;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartService {
    private final PartRepository partRepository;

    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    public List<Part> getAllParts() {
        return partRepository.findAll();
    }

    // New method to search parts by query
    public List<Part> searchParts(String query) {
        return partRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query);
    }

    public List<Part> searchPartsByName(String name) {
        return partRepository.findByNameContainingIgnoreCase(name);
    }
}