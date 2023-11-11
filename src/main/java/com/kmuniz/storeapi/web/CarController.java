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
public class CarController {
    @Autowired
    private CarService carService;

    // Endpoint to get all car brands
    @GetMapping(value="/brands", produces = "application/json")
    public List<CarMakerEntity> getAllCarBrands() {
        return carService.getAllCarBrands();
    }
    // Endpoint to get all car models
    @GetMapping(value="/models", produces = "application/json")
    public List<CarModelEntity> getAllCarModels() {
        return carService.getAllCarModels();
    }


    // Endpoint to get car models for a specific brand
    @GetMapping(value="/models/{brandName}", produces = "application/json")
    public List<CarModelEntity> getCarModelsByBrand(@PathVariable String brandName) {
        return carService.getCarModelsByBrand(brandName);
    }
    @GetMapping(value = "/models/{model}", produces = "application/json")
    public List<CarVersionEntity> getCarVersionByModel(@PathVariable String model){

        return  carService.getCarVersionByModel(model);
    }

    @GetMapping(value = "/home")
    public String getHome(Model model){
        model.addAttribute("something", "This come form the controller");
        return "home";
    }
}
