package com.kmuniz.storeapi.web;


import com.kmuniz.storeapi.domain.entity.CarMakerEntity;
import com.kmuniz.storeapi.domain.entity.CarModelEntity;
import com.kmuniz.storeapi.domain.entity.CarVersionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kmuniz.storeapi.service.CarService;

import java.util.List;


@Controller
@RequestMapping("/api/car")
public class CarModelController {

    @Autowired
    private CarService carService;

    // Endpoint to get all car brands
    @GetMapping(value = "/brands", produces = "application/json")
    public List<CarMakerEntity> getAllCarBrands() {
        return carService.getAllCarBrands();
    }

    // Endpoint to get all car models
    @GetMapping(value = "/models", produces = "application/json")
    public List<CarModelEntity> getAllCarModels() {
        return carService.getAllCarModels();
    }

    // Endpoint to get car models for a specific brand
    @GetMapping(value = "/brands/{brandName}/models", produces = "application/json")
    public List<CarModelEntity> getCarModelsByBrand(@PathVariable String brandName) {
        return carService.getCarModelsByBrand(brandName);
    }

    // Endpoint to get car versions for a specific model
    @GetMapping(value = "/models/{modelName}/versions", produces = "application/json")
    public List<CarVersionEntity> getCarVersionsByModel(@PathVariable String modelName) {
        return carService.getCarVersionByModel(modelName);
    }

    // Example endpoint to return data to a view (e.g., HTML page)
    @GetMapping(value = "/home")
    public String getHome(Model model) {
        model.addAttribute("something", "This comes from the controller");
        return "home";
    }
}
