package com.robosh.controller;

import com.robosh.entities.User;
import com.robosh.services.impl.UserServiceImpl;
import com.robosh.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute(value="userForm") User userForm, BindingResult bindingResult, Model model) {
//        User userFromDb = userService.findByEmail(user.getEmail());
//        if (userFromDb != null) {
//            model.put("message", "User with such email is exist");
//            return "registration";
//        }
//        userService.register(user);
//        return "redirect:/login";
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "registration";
        }
        userService.save(userForm);
        return "redirect:/login";
    }

}
