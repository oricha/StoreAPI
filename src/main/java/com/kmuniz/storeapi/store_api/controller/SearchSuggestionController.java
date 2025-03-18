package com.kmuniz.storeapi.store_api.controller;

import com.kmuniz.storeapi.store_api.model.SearchSuggestionDTO;
import com.kmuniz.storeapi.store_api.service.SearchSuggestionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/search")
@CrossOrigin(origins = "*")
public class SearchSuggestionController {
    
    private static final Logger logger = LoggerFactory.getLogger(SearchSuggestionController.class);
    private final SearchSuggestionService searchSuggestionService;

    public SearchSuggestionController(SearchSuggestionService searchSuggestionService) {
        this.searchSuggestionService = searchSuggestionService;
    }

    @GetMapping("/suggestions")
    public List<SearchSuggestionDTO> getSuggestions(@RequestParam(name = "query") String query) {
        logger.info("Received search suggestion request for query: {}", query);
        List<SearchSuggestionDTO> suggestions = searchSuggestionService.getSuggestions(query);
        logger.info("Returning {} suggestions", suggestions.size());
        return suggestions;
    }
} 