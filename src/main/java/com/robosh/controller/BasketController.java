package com.robosh.controller;

import com.robosh.entities.Dish;
import com.robosh.entities.Drink;
import com.robosh.entities.OrderProducts;
import com.robosh.services.impl.OrderProductsServiceImpl;
import com.robosh.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/basket")
public class BasketController {

    private OrderProductsServiceImpl orderProductsService;
    private UserServiceImpl userService;
    private OrderProducts orderProducts;

    @Autowired
    public BasketController(OrderProductsServiceImpl orderProductsService, UserServiceImpl userService) {
        this.orderProductsService = orderProductsService;
        this.userService = userService;
    }

    @RequestMapping
    public String basket(Model model) {
        orderProducts = orderProductsService.getOrderProductsForUser(userService.getFromAuthentication());
        model.addAttribute("products", orderProducts);
        model.addAttribute("totalPrice", orderProductsService.getTotalPrice(orderProducts));
        return "users/user/basket";
    }

    @PostMapping("/dish/{dish}")
    public String addDish(@PathVariable Dish dish) {
        orderProducts = orderProductsService.getOrderProductsForUser(userService.getFromAuthentication());
        orderProductsService.addFood(orderProducts, dish);
        return "redirect:/menu";
    }

    @PostMapping("/drink/{drink}")
    public String addDrink(@PathVariable Drink drink) {
        orderProducts = orderProductsService.getOrderProductsForUser(userService.getFromAuthentication());
        orderProductsService.addFood(orderProducts, drink);
        return "redirect:/menu";
    }

    @DeleteMapping("/drink/{drink}")
    public String deleteDrink(@PathVariable Drink drink) {
        orderProducts = orderProductsService.getOrderProductsForUser(userService.getFromAuthentication());
        orderProductsService.deleteFood(orderProducts, drink);
        return "redirect:/user/basket";
    }

    @DeleteMapping("/dish/{dish}")
    public String deleteDish(@PathVariable Dish dish) {
        orderProducts = orderProductsService.getOrderProductsForUser(userService.getFromAuthentication());
        orderProductsService.deleteFood(orderProducts, dish);
        return "redirect:/user/basket";
    }

}
