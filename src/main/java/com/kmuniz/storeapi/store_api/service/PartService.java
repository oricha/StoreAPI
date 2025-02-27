package com.kmuniz.storeapi.store_api.service;

import com.kmuniz.storeapi.store_api.domain.part.PartRepository;
import com.kmuniz.storeapi.store_api.domain.part.Part;
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