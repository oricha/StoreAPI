package com.kmuniz.storeapi.store_api.controller.admin;

import com.kmuniz.storeapi.store_api.model.PartsDTO;
import com.kmuniz.storeapi.store_api.service.PartsService;
import com.kmuniz.storeapi.store_api.util.WebUtils;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/partss")
public class AdminPartsController {

    private final PartsService partsService;

    public AdminPartsController(final PartsService partsService) {
        this.partsService = partsService;
    }


    @GetMapping
    public String list(final Model model) {
        model.addAttribute("partses", partsService.findAll());
        return "parts/list";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("parts") final PartsDTO partsDTO) {
        return "parts/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("parts") @Valid final PartsDTO partsDTO,
                      final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "parts/add";
        }
        partsService.create(partsDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("parts.create.success"));
        return "redirect:/partss";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") final Long id, final Model model) {
        model.addAttribute("parts", partsService.get(id));
        return "parts/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") final Long id,
                       @ModelAttribute("parts") @Valid final PartsDTO partsDTO,
                       final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "parts/edit";
        }
        partsService.update(id, partsDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("parts.update.success"));
        return "redirect:/partss";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") final Long id,
                         final RedirectAttributes redirectAttributes) {
        partsService.delete(id);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("parts.delete.success"));
        return "redirect:/partss";
    }

    @GetMapping("/search")
    public String searchParts(
            @RequestParam("brandId") Long brandId,
            @RequestParam("modelId") Long modelId,
            @RequestParam("engineId") Long engineId,
            @RequestParam(value = "partName", required = false) String partName,
            Model model) {

        List<PartsDTO> parts = partsService.searchParts(brandId, modelId, engineId, partName);
        model.addAttribute("parts", parts);
        return "shop-list/shop-right-sidebar-list"; // Adjust the view name as needed
    }
}
