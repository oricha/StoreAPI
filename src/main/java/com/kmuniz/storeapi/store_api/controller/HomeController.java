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
    public String index1() {
        return "home/index-1";
    }

    @GetMapping("/index-2")
    public String index2() {
        return "home/index-2";
    }

    @GetMapping("/index-3")
    public String index3() {
        return "home/index-3";
    }

    @GetMapping("/index-4")
    public String index4() {
        return "home/index-4";
    }

    @GetMapping("/index-5")
    public String index5() {
        return "home/index-5";
    }

    @GetMapping("/index-6")
    public String index6() {
        return "home/index-6";
    }

    @GetMapping("/index-7")
    public String index7() {
        return "home/index-7";
    }

    @GetMapping("/index-list")
    public String indexList() {
        return "shop-list/shop-right-sidebar-list";
    }
}
