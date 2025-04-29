package com.kmuniz.storeapi.store_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.kmuniz.storeapi.store_api.service.SearchEngineService;

@Controller
public class SearchEngineController {
    
    private final SearchEngineService searchEngineService;

    public SearchEngineController(SearchEngineService searchEngineService) {
        this.searchEngineService = searchEngineService;
    }
    
    @GetMapping("/search-engine")
    public String search(@RequestParam("query") String query, Model model) {
        var searchResults = searchEngineService.processSearch(query);
        model.addAttribute("searchResults", searchResults);
        return "shop-list/shop-right-sidebar-list";
    }
}
