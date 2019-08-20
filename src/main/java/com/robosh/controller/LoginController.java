package com.robosh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class LoginController {

    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "login.invalid");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

}
