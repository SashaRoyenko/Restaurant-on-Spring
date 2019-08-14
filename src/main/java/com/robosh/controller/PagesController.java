package com.robosh.controller;

import com.robosh.entities.Dish;
import com.robosh.entities.Drink;
import com.robosh.entities.OrderProducts;
import com.robosh.repositories.DishRepository;
import com.robosh.repositories.DrinkRepository;
import com.robosh.repositories.OrderProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PagesController {
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private DrinkRepository drinkRepository;



    @GetMapping("/menu")
    public void menu(Model model) {
        List<Drink> drinks = drinkRepository.findAll();
        List<Dish> dishes = dishRepository.findAll();
        model.addAttribute("drinks", drinks);
        model.addAttribute("dishes", dishes);
    }

}
