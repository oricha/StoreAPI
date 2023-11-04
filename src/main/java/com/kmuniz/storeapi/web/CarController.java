package com.kmuniz.storeapi.web;


import com.kmuniz.storeapi.domain.entity.CarMaker;
import com.kmuniz.storeapi.domain.entity.CarModel;
import com.kmuniz.storeapi.domain.entity.CarVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kmuniz.storeapi.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    private CarService carService;

    // Endpoint to get all car brands
    @GetMapping(value="/brands", produces = "application/json")
    public List<CarMaker> getAllCarBrands() {
        return carService.getAllCarBrands();
    }
    // Endpoint to get all car models
    @GetMapping(value="/models", produces = "application/json")
    public List<CarModel> getAllCarModels() {
        return carService.getAllCarModels();
    }


    // Endpoint to get car models for a specific brand
    @GetMapping(value="/models/{brandName}", produces = "application/json")
    public List<CarModel> getCarModelsByBrand(@PathVariable String brandName) {
        return carService.getCarModelsByBrand(brandName);
    }
    @GetMapping(value = "/models/{model}", produces = "application/json")
    public List<CarVersion> getCarVersionByModel(@PathVariable String model){

        return  carService.getCarVersionByModel(model);
    }
}
