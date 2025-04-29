package com.kmuniz.storeapi.store_api.controller;

import com.kmuniz.storeapi.store_api.model.PartsDTO;
import com.kmuniz.storeapi.store_api.service.PartsService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/partss")
public class PartsController {

    private final PartsService partsService;

    public PartsController(final PartsService partsService) {
        this.partsService = partsService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PartsDTO>> searchPartsJson() {
        List<PartsDTO> parts = partsService.findAll();
        return ResponseEntity.ok(parts);
    }

}
