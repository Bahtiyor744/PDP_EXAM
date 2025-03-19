package com.example.pdp_project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class AuthController {

    @GetMapping
    public String loginPage(@RequestParam(name = "error", required = false) String error, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Ro'yhatdan o'tmagansiz avval");
        }
        return "login"; // /src/main/resources/templates/login.html
    }
}

