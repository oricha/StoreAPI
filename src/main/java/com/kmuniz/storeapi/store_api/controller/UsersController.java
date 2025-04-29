package com.kmuniz.storeapi.store_api.controller;

import com.kmuniz.storeapi.store_api.model.UsersDTO;
import com.kmuniz.storeapi.store_api.service.UsersService;
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
@RequestMapping("/userss")
public class UsersController {

    private final UsersService usersService;

    public UsersController(final UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public String list(final Model model) {
        model.addAttribute("userses", usersService.findAll());
        return "users/list";
    }
}
