package com.holdOrder.HoldOrder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController2 {

    @GetMapping("/home3")
    public String homepage3() {
        return "home3";
    }

}
