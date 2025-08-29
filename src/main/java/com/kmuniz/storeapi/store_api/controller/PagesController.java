package com.kmuniz.storeapi.store_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @GetMapping("/about")
    public String about() {
        return "pages/about";
    }

    @GetMapping("/cart")
    public String cart() {
        return "pages/cart";
    }
    @GetMapping("/checkout")
    public String checkout() {
        return "pages/checkout";
    }
    @GetMapping("/contact")
    public String contact() {
        return "pages/contact";
    }

    @GetMapping("/faq" )
    public String faq() {
        return "pages/faq";
    }
    @GetMapping("/compare")
    public String compare() {
        return "pages/compare";
    }

    @GetMapping("/wishlist")
    public String wishlist() {
        return "pages/wishlist";

    }
}
