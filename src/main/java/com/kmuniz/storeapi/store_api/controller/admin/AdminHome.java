package com.kmuniz.storeapi.store_api.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminHome {

    @GetMapping("/")
    public String index() {
        return "home/index";
    }
}
