package com.kmuniz.storeapi.store_api.service;


import com.kmuniz.storeapi.store_api.domain.category.CategoryRepository;
import org.springframework.stereotype.Service;
import com.kmuniz.storeapi.store_api.domain.category.Category;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}