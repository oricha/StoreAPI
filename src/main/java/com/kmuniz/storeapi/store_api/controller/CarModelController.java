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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping
    public String list(final Model model) {
        model.addAttribute("carModels", carModelService.findAll());
        return "carModel/list";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("carModel") final CarModelDTO carModelDTO) {
        return "carModel/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("carModel") @Valid final CarModelDTO carModelDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "carModel/add";
        }
        carModelService.create(carModelDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("carModel.create.success"));
        return "redirect:/carModels";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") final Long id, final Model model) {
        model.addAttribute("carModel", carModelService.get(id));
        return "carModel/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") final Long id,
            @ModelAttribute("carModel") @Valid final CarModelDTO carModelDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "carModel/edit";
        }
        carModelService.update(id, carModelDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("carModel.update.success"));
        return "redirect:/carModels";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") final Long id,
            final RedirectAttributes redirectAttributes) {
        final ReferencedWarning referencedWarning = carModelService.getReferencedWarning(id);
        if (referencedWarning != null) {
            redirectAttributes.addFlashAttribute(WebUtils.MSG_ERROR,
                    WebUtils.getMessage(referencedWarning.getKey(), referencedWarning.getParams().toArray()));
        } else {
            carModelService.delete(id);
            redirectAttributes.addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("carModel.delete.success"));
        }
        return "redirect:/carModels";
    }

    @GetMapping("/search")
    public String searchByCarMaker(@RequestParam("carMakerId") Long carMakerId, Model model) {
        List<CarModelDTO> carModels = carModelService.findByCarMakerId(carMakerId);
        model.addAttribute("carModels", carModels);
        return "carModel/list"; // Adjust the view name as needed
    }

}
