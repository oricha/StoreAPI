package com.kmuniz.storeapi.web;
import com.kmuniz.storeapi.domain.entity.Part;
import com.kmuniz.storeapi.service.PartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PartController {
    private final PartService partService;

    public PartController(PartService partService) {
        this.partService = partService;
    }

    // Existing endpoint for listing parts
    @GetMapping("/parts")
    public List<Part> getAllParts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String model
    ) {
        List<Part> parts = partService.getAllParts();

        // Optional filtering
        if (category != null) {
            parts = parts.stream().filter(part -> part.getCategory().equalsIgnoreCase(category)).toList();
        }
        if (brand != null) {
            parts = parts.stream().filter(part -> part.getBrand().equalsIgnoreCase(brand)).toList();
        }
        if (model != null) {
            parts = parts.stream().filter(part -> part.getModel().equalsIgnoreCase(model)).toList();
        }

        return parts;
    }

    // New endpoint for searching parts
    @GetMapping("/parts/search")
    public List<Part> searchParts(@RequestParam String query) {
        return partService.searchParts(query);
    }

    @GetMapping("/search-by-name")
    public List<Part> searchPartsByName(@RequestParam String name) {
        return partService.searchPartsByName(name);
    }
}