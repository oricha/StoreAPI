package com.kmuniz.storeapi.store_api.controller;

import com.kmuniz.storeapi.store_api.domain.CarMaker;
import com.kmuniz.storeapi.store_api.model.CarModelDTO;
import com.kmuniz.storeapi.store_api.repos.CarMakerRepository;
import com.kmuniz.storeapi.store_api.service.CarModelService;
import com.kmuniz.storeapi.store_api.util.CustomCollectors;
import com.kmuniz.storeapi.store_api.util.ReferencedWarning;
import com.kmuniz.storeapi.store_api.util.WebUtils;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/carModels")
public class CarModelController {

    private final CarModelService carModelService;
    private final CarMakerRepository carMakerRepository;

    public CarModelController(final CarModelService carModelService,
            final CarMakerRepository carMakerRepository) {
        this.carModelService = carModelService;
        this.carMakerRepository = carMakerRepository;
    }

    @ModelAttribute
    public void prepareContext(final Model model) {
        model.addAttribute("carMakerValues", carMakerRepository.findAll(Sort.by("id"))
                .stream()
                .collect(CustomCollectors.toSortedMap(CarMaker::getId, CarMaker::getName)));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CarModelDTO>> searchCarModelsJson() {
        List<CarModelDTO> carModels = carModelService.findAll();
        return ResponseEntity.ok(carModels);
    }

}
