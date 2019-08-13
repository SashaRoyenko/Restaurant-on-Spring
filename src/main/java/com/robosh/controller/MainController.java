package com.robosh.controller;

import com.robosh.entities.*;
import com.robosh.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private DrinkRepository drinkRepository;
    @Autowired
    private OrderProductsRepository orderProductsRepository;

    @GetMapping("/home")
    public String index(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }

    @GetMapping("/")
    public String test(Model model){
        List<User> users = userRepository.findAll();
        List<Drink> drinks = drinkRepository.findAll();
        List<Ingredient> ingredients = ingredientRepository.findAll();
        List<Dish> dishes = dishRepository.findAll();
        List<Order> orders = orderRepository.findAll();
        List<OrderProducts> orderProducts = orderProductsRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("drinks", drinks);
        model.addAttribute("dishes", dishes);
        model.addAttribute("orders", orders);
        model.addAttribute("orderProducts", orderProducts);

        return "test";
    }
}
