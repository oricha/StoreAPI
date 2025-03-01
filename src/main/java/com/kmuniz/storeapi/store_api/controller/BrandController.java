package com.kmuniz.storeapi.store_api.controller;

import com.kmuniz.storeapi.store_api.model.BrandDTO;
import com.kmuniz.storeapi.store_api.service.BrandService;
import com.kmuniz.storeapi.store_api.util.WebUtils;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(final BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public String list(final Model model) {
        model.addAttribute("brands", brandService.findAll());
        return "brand/list";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("brand") final BrandDTO brandDTO) {
        return "brand/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("brand") @Valid final BrandDTO brandDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "brand/add";
        }
        brandService.create(brandDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("brand.create.success"));
        return "redirect:/brands";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") final Long id, final Model model) {
        model.addAttribute("brand", brandService.get(id));
        return "brand/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") final Long id,
            @ModelAttribute("brand") @Valid final BrandDTO brandDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "brand/edit";
        }
        brandService.update(id, brandDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("brand.update.success"));
        return "redirect:/brands";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") final Long id,
            final RedirectAttributes redirectAttributes) {
        brandService.delete(id);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("brand.delete.success"));
        return "redirect:/brands";
    }

}
