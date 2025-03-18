package com.kmuniz.storeapi.store_api.service;

import com.kmuniz.storeapi.store_api.model.SearchSuggestionDTO;
import com.kmuniz.storeapi.store_api.domain.CarModel;
import com.kmuniz.storeapi.store_api.repos.CarMakerRepository;
import com.kmuniz.storeapi.store_api.repos.CarModelRepository;
import com.kmuniz.storeapi.store_api.repos.CarVersionRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchSuggestionService {
    
    private static final Logger logger = LoggerFactory.getLogger(SearchSuggestionService.class);
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
        logger.debug("Getting suggestions for query: {}", query);
        List<SearchSuggestionDTO> suggestions = new ArrayList<>();
        String lowercaseQuery = query.toLowerCase();

        // Search for car makes
        carMakerRepository.findByNameContainingIgnoreCase(lowercaseQuery)
            .ifPresent(maker -> {
                logger.debug("Found car maker: {}", maker.getName());
                SearchSuggestionDTO suggestion = new SearchSuggestionDTO();
                suggestion.setId(maker.getId());
                suggestion.setName(maker.getName());
                suggestion.setType("MAKE");
                suggestions.add(suggestion);

                // If we find a make, also search for its models
                List<CarModel> models = carModelRepository.findByCarMakerId(maker.getId());
                logger.debug("Found {} models for maker {}", models.size(), maker.getName());
                
                models.stream()
                    .filter(model -> model.getName().toLowerCase().contains(lowercaseQuery))
                    .forEach(model -> {
                        SearchSuggestionDTO modelSuggestion = new SearchSuggestionDTO();
                        modelSuggestion.setId(model.getId());
                        modelSuggestion.setName(maker.getName() + " " + model.getName());
                        modelSuggestion.setType("MODEL");
                        suggestions.add(modelSuggestion);
                        logger.debug("Added model suggestion: {}", modelSuggestion.getName());
                    });
            });

        // Also search directly for models if query might be a model name
        carModelRepository.findByNameContainingIgnoreCase(lowercaseQuery)
            .ifPresent(model -> {
                logger.debug("Found model by direct search: {}", model.getName());
                SearchSuggestionDTO suggestion = new SearchSuggestionDTO();
                suggestion.setId(model.getId());
                suggestion.setName(model.getCarMaker().getName() + " " + model.getName());
                suggestion.setType("MODEL");
                suggestions.add(suggestion);
            });

        logger.debug("Returning {} total suggestions", suggestions.size());
        return suggestions;
    }
} 