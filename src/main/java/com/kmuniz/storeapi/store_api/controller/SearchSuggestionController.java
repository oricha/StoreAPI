package com.kmuniz.storeapi.store_api.controller;

import com.kmuniz.storeapi.store_api.model.SearchSuggestionDTO;
import com.kmuniz.storeapi.store_api.service.SearchSuggestionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchSuggestionController {

    private final SearchSuggestionService searchSuggestionService;

    public SearchSuggestionController(SearchSuggestionService searchSuggestionService) {
        this.searchSuggestionService = searchSuggestionService;
    }

    @GetMapping("/suggestions")
    public List<SearchSuggestionDTO> getSuggestions(@RequestParam String query) {
        return searchSuggestionService.getSuggestions(query);
    }
} 