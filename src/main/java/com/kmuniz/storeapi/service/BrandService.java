package com.kmuniz.storeapi.service;

import com.kmuniz.storeapi.domain.BrandRepository;
import com.kmuniz.storeapi.domain.entity.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }
}