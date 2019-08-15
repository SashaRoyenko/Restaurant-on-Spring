package com.robosh.controller;

import com.robosh.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private
    UserServiceImpl userService;

    @GetMapping
    public String getUser() {
        return "redirect:/" + userService.getFromAuthentication().getRole().toString().toLowerCase() + "/account";
    }
}
