package com.kmuniz.storeapi.store_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "home/index";
    }

    @GetMapping("/index-1")
    public String home() {
        return "home/index-1";
    }

}
