package com.robosh.controller;

import com.robosh.entities.User;
import com.robosh.services.impl.UserServiceImpl;
import com.robosh.validator.RegisterUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    private UserServiceImpl userService;
    private RegisterUserValidator registerUserValidator;

    @Autowired
    public RegistrationController(UserServiceImpl userService, RegisterUserValidator registerUserValidator) {
        this.userService = userService;
        this.registerUserValidator = registerUserValidator;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(User user, BindingResult bindingResult, Model model) {

        registerUserValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(user);
        return "redirect:/login";
    }


}
