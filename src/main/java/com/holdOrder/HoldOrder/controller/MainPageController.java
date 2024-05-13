package com.holdOrder.HoldOrder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @GetMapping("/home")
    public String homepage() {
        return "home";
    }

    @GetMapping("/home2")
    public String homepage2() {
        return "home2";
    }


}
