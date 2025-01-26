package com.kmuniz.storeapi.service;

import com.kmuniz.storeapi.domain.entity.Brand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brands")
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

}