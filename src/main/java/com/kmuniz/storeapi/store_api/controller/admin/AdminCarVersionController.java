package com.kmuniz.storeapi.store_api.controller.admin;

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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/carVersions")
public class AdminCarVersionController {

    private final CarVersionService carVersionService;
    private final CarMakerRepository carMakerRepository;
    private final CarModelRepository carModelRepository;

    public AdminCarVersionController(final CarVersionService carVersionService,
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

    @GetMapping
    public String list(final Model model) {
        model.addAttribute("carVersions", carVersionService.findAll());
        return "carVersion/list";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("carVersion") final CarVersionDTO carVersionDTO) {
        return "carVersion/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("carVersion") @Valid final CarVersionDTO carVersionDTO,
                      final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "carVersion/add";
        }
        carVersionService.create(carVersionDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("carVersion.create.success"));
        return "redirect:/carVersions";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") final Long id, final Model model) {
        model.addAttribute("carVersion", carVersionService.get(id));
        return "carVersion/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") final Long id,
                       @ModelAttribute("carVersion") @Valid final CarVersionDTO carVersionDTO,
                       final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "carVersion/edit";
        }
        carVersionService.update(id, carVersionDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("carVersion.update.success"));
        return "redirect:/carVersions";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") final Long id,
                         final RedirectAttributes redirectAttributes) {
        carVersionService.delete(id);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("carVersion.delete.success"));
        return "redirect:/carVersions";
    }

    @GetMapping("/search")
    public String searchByCarModel(@RequestParam("carModelId") Long carModelId, Model model) {
        List<CarVersionDTO> carVersions = carVersionService.findByCarModelId(carModelId);
        model.addAttribute("carVersions", carVersions);
        return "carVersion/list"; // Adjust the view name as needed
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CarVersionDTO>> searchByCarModelJson(@RequestParam("carModelId") Long carModelId, Model model) {
        List<CarVersionDTO> carVersions = carVersionService.findByCarModelId(carModelId);
        model.addAttribute("carVersions", carVersions);
        return ResponseEntity.ok(carVersions);
    }
}
