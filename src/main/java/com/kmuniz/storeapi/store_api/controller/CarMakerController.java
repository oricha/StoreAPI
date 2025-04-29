package com.kmuniz.storeapi.store_api.controller;

import com.kmuniz.storeapi.store_api.model.CarMakerDTO;
import com.kmuniz.storeapi.store_api.service.CarMakerService;
import com.kmuniz.storeapi.store_api.util.ReferencedWarning;
import com.kmuniz.storeapi.store_api.util.WebUtils;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/carMakers")
public class CarMakerController {

    private final CarMakerService carMakerService;

    public CarMakerController(final CarMakerService carMakerService) {
        this.carMakerService = carMakerService;
    }

    @GetMapping
    public String list(final Model model) {
        model.addAttribute("carMakers", carMakerService.findAll());
        return "carMaker/list";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CarMakerDTO>> searchCarMakersJson() {
        List<CarMakerDTO> carMakers = carMakerService.findAll();
        return ResponseEntity.ok(carMakers);
    }

}
