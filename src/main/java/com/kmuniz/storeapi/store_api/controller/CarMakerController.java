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
    @GetMapping("/add")
    public String add(@ModelAttribute("carMaker") final CarMakerDTO carMakerDTO) {
        return "carMaker/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("carMaker") @Valid final CarMakerDTO carMakerDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "carMaker/add";
        }
        carMakerService.create(carMakerDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("carMaker.create.success"));
        return "redirect:/carMakers";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") final Long id, final Model model) {
        model.addAttribute("carMaker", carMakerService.get(id));
        return "carMaker/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") final Long id,
            @ModelAttribute("carMaker") @Valid final CarMakerDTO carMakerDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "carMaker/edit";
        }
        carMakerService.update(id, carMakerDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("carMaker.update.success"));
        return "redirect:/carMakers";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") final Long id,
            final RedirectAttributes redirectAttributes) {
        final ReferencedWarning referencedWarning = carMakerService.getReferencedWarning(id);
        if (referencedWarning != null) {
            redirectAttributes.addFlashAttribute(WebUtils.MSG_ERROR,
                    WebUtils.getMessage(referencedWarning.getKey(), referencedWarning.getParams().toArray()));
        } else {
            carMakerService.delete(id);
            redirectAttributes.addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("carMaker.delete.success"));
        }
        return "redirect:/carMakers";
    }


}
