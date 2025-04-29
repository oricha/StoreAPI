package com.kmuniz.storeapi.store_api.controller;

import com.kmuniz.storeapi.store_api.domain.CarMaker;
import com.kmuniz.storeapi.store_api.domain.CarModel;
import com.kmuniz.storeapi.store_api.model.CarVersionDTO;
import com.kmuniz.storeapi.store_api.repos.CarMakerRepository;
import com.kmuniz.storeapi.store_api.repos.CarModelRepository;
import com.kmuniz.storeapi.store_api.service.CarVersionService;
import com.kmuniz.storeapi.store_api.util.CustomCollectors;
import com.kmuniz.storeapi.store_api.util.WebUtils;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/carVersions")
public class CarVersionController {

    private final CarVersionService carVersionService;
    private final CarMakerRepository carMakerRepository;
    private final CarModelRepository carModelRepository;

    public CarVersionController(final CarVersionService carVersionService,
            final CarMakerRepository carMakerRepository,
            final CarModelRepository carModelRepository) {
        this.carVersionService = carVersionService;
        this.carMakerRepository = carMakerRepository;
        this.carModelRepository = carModelRepository;
    }

    @ModelAttribute
    public void prepareContext(final Model model) {
        model.addAttribute("carMakerValues", carMakerRepository.findAll(Sort.by("id"))
                .stream()
                .collect(CustomCollectors.toSortedMap(CarMaker::getId, CarMaker::getName)));
        model.addAttribute("carModelValues", carModelRepository.findAll(Sort.by("id"))
                .stream()
                .collect(CustomCollectors.toSortedMap(CarModel::getId, CarModel::getName)));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CarVersionDTO>> searchCarVersionsJson() {
        List<CarVersionDTO> carVersions = carVersionService.findAll();
        return ResponseEntity.ok(carVersions);
    }

}
