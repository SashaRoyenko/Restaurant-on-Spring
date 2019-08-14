package com.robosh.controller;

import com.robosh.entities.Dish;
import com.robosh.entities.Drink;
import com.robosh.entities.OrderProducts;
import com.robosh.entities.User;
import com.robosh.services.impl.OrderProductsServiceImpl;
import com.robosh.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;

@Controller
//@RequestMapping("/user/basket")
public class BasketController {
    @Autowired
    private OrderProductsServiceImpl orderProductsService;

    @Autowired
    private UserServiceImpl userService;

    private OrderProducts orderProducts;

    @PostConstruct
    public void init(){
//        User user = userService.getFromAuthentication();
//        if(user != null) {
//            orderProducts = orderProductsService.findByUser(user);
//        }
    }

    @GetMapping("/user/basket")
    public String basket(Model model){
        User user = userService.getFromAuthentication();
        orderProducts = orderProductsService.findByUser(user);

        model.addAttribute("products", orderProducts);
        model.addAttribute("totalPrice", orderProductsService.getTotalPrice(orderProducts));
        return "users/user/basket";
    }

    @PostMapping("/user/basket/dish/{dish}")
    public String addDish(@PathVariable Dish dish, Model model) {
        User user = userService.getFromAuthentication();
        orderProducts = orderProductsService.findByUser(user);

        orderProductsService.addFood(orderProducts, dish);
        return "redirect:/menu";
    }

    @PostMapping("/user/basket/drink/{drink}")
    public String addDrink(@PathVariable Drink drink, Model model) {
        User user = userService.getFromAuthentication();
        orderProducts = orderProductsService.findByUser(user);

        orderProductsService.addFood(orderProducts, drink);
        return "redirect:/menu";
    }
}
