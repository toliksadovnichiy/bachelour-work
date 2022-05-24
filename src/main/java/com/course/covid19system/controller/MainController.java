package com.course.covid19system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title", "Головна сторінка");
        return "home";
    }

    @GetMapping("/info")
    public String info(Model model){
        model.addAttribute("title", "Інформація");
        return "info";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title", "Контакти");
        return "about";
    }

}
