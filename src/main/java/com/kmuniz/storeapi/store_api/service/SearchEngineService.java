package com.kmuniz.storeapi.store_api.service;

import org.springframework.stereotype.Service;
import com.kmuniz.storeapi.store_api.model.PartsDTO;
import com.kmuniz.storeapi.store_api.service.CarMakerService;
import com.kmuniz.storeapi.store_api.service.CarModelService;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class SearchEngineService {
    
    private final CarMakerService carMakerService;
    private final CarModelService carModelService;
    private final PartsService partsService;

    public SearchEngineService(
            CarMakerService carMakerService,
            CarModelService carModelService,
            PartsService partsService) {
        this.carMakerService = carMakerService;
        this.carModelService = carModelService;
        this.partsService = partsService;
    }

    public List<PartsDTO> processSearch(String query) {
        // Split the search query into words
        String[] words = query.toLowerCase().split("\\s+");
        
        Long brandId = null;
        Long modelId = null;
        
        // Try to match make and model
        for (String word : words) {
            // First try to find a car maker match
            if (brandId == null) {
                var maker = carMakerService.findByNameContaining(word);
                if (maker != null) {
                    brandId = maker.getId();
                    continue;
                }
            }
            
            // Then try to find a model match
            if (modelId == null) {
                var model = carModelService.findByNameContaining(word);
                if (model != null) {
                    modelId = model.getId();
                    // If we found a model but no brand, get its brand
                    if (brandId == null) {
                        brandId = model.getCarMaker();
                    }
                }
            }
        }
        
        // If we found either a brand or model, search for parts
        if (brandId != null || modelId != null) {
            return partsService.searchParts(brandId, modelId, null, query);
        }
        
        // If no car make/model found, search only by part name/code
        return partsService.searchByNameOrCode(query);
    }
} 