package com.robosh.controller;

import com.robosh.entities.Dish;
import com.robosh.entities.Drink;
import com.robosh.repositories.DishRepository;
import com.robosh.repositories.DrinkRepository;
import com.robosh.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PagesController {
    private DishRepository dishRepository;
    private DrinkRepository drinkRepository;
    private UserService userService;

    @Autowired
    public PagesController(DishRepository dishRepository, DrinkRepository drinkRepository, UserService userService) {
        this.dishRepository = dishRepository;
        this.drinkRepository = drinkRepository;
        this.userService = userService;
    }


    @GetMapping("/menu")
    public void menu(Model model) {
        model.addAttribute("drinks", drinkRepository.findAll());
        model.addAttribute("dishes", dishRepository.findAll());
    }

    @GetMapping("/user")
    public String getUser() {
        return "redirect:/" + userService.getFromAuthentication().getRole().toString().toLowerCase() + "/account";
    }
}
