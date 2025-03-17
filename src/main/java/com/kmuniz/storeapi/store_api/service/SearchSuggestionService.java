package com.kmuniz.storeapi.store_api.service;

import com.kmuniz.storeapi.store_api.model.SearchSuggestionDTO;
import com.kmuniz.storeapi.store_api.repos.CarMakerRepository;
import com.kmuniz.storeapi.store_api.repos.CarModelRepository;
import com.kmuniz.storeapi.store_api.repos.CarVersionRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchSuggestionService {

    private final CarMakerRepository carMakerRepository;
    private final CarModelRepository carModelRepository;
    private final CarVersionRepository carVersionRepository;

    public SearchSuggestionService(
            CarMakerRepository carMakerRepository,
            CarModelRepository carModelRepository,
            CarVersionRepository carVersionRepository) {
        this.carMakerRepository = carMakerRepository;
        this.carModelRepository = carModelRepository;
        this.carVersionRepository = carVersionRepository;
    }

    public List<SearchSuggestionDTO> getSuggestions(String query) {
        List<SearchSuggestionDTO> suggestions = new ArrayList<>();
        String lowercaseQuery = query.toLowerCase();

        // Search for car makes
        carMakerRepository.findByNameContainingIgnoreCase(lowercaseQuery)
            .ifPresent(maker -> {
                SearchSuggestionDTO suggestion = new SearchSuggestionDTO();
                suggestion.setId(maker.getId());
                suggestion.setName(maker.getName());
                suggestion.setType("MAKE");
                suggestions.add(suggestion);

                // If we find a make, also search for its models
                carModelRepository.findByCarMakerId(maker.getId())
                    .stream()
                    .filter(model -> model.getName().toLowerCase().contains(lowercaseQuery))
                    .forEach(model -> {
                        SearchSuggestionDTO modelSuggestion = new SearchSuggestionDTO();
                        modelSuggestion.setId(model.getId());
                        modelSuggestion.setName(maker.getName() + " " + model.getName());
                        modelSuggestion.setType("MODEL");
                        suggestions.add(modelSuggestion);
                    });
            });

        // Also search directly for models if query might be a model name
        carModelRepository.findByNameContainingIgnoreCase(lowercaseQuery)
            .ifPresent(model -> {
                SearchSuggestionDTO suggestion = new SearchSuggestionDTO();
                suggestion.setId(model.getId());
                suggestion.setName(model.getCarMaker().getName() + " " + model.getName());
                suggestion.setType("MODEL");
                suggestions.add(suggestion);
            });

        return suggestions;
    }
} 