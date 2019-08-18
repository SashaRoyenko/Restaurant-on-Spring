package com.robosh.controller;

import com.robosh.entities.Dish;
import com.robosh.entities.Drink;
import com.robosh.entities.OrderProducts;
import com.robosh.entities.User;
import com.robosh.services.impl.OrderProductsServiceImpl;
import com.robosh.services.impl.UserServiceImpl;
import org.apache.tomcat.jni.Thread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user/basket")
public class BasketController {
    @Autowired
    private OrderProductsServiceImpl orderProductsService;

    @Autowired
    private UserServiceImpl userService;

    private OrderProducts orderProducts;

    private OrderProducts getOrderProducts() {
        User user = userService.getFromAuthentication();
        orderProducts = orderProductsService.findByUser(user);
        if (orderProducts == null) {
            orderProducts = new OrderProducts();
            orderProducts.setUser(user);
            orderProductsService.save(orderProducts);
            orderProducts = orderProductsService.findByUser(user);
        }
        return orderProducts;
    }

    @RequestMapping
    public String basket(Model model) {
        orderProducts = getOrderProducts();
        model.addAttribute("products", orderProducts);
        Float totalPrice = orderProductsService.getTotalPrice(orderProducts);
        if (totalPrice != null) {
            model.addAttribute("totalPrice", totalPrice);
        }
        return "users/user/basket";
    }

    @PostMapping("/dish/{dish}")
    public String addDish(@PathVariable Dish dish) {
        orderProducts = getOrderProducts();
        orderProductsService.addFood(orderProducts, dish);
        return "redirect:/menu";
    }

    @PostMapping("/drink/{drink}")
    public String addDrink(@PathVariable Drink drink) {
        orderProducts = getOrderProducts();
        orderProductsService.addFood(orderProducts, drink);
        return "redirect:/menu";
    }

    @DeleteMapping("/drink/{drink}")
    public String deleteDrink(@PathVariable Drink drink) {
        orderProducts = getOrderProducts();
        orderProductsService.deleteFood(orderProducts, drink);
        return "redirect:/user/basket";
    }

    @DeleteMapping("/dish/{dish}")
    public String deleteDish(@PathVariable Dish dish) {
        orderProducts = getOrderProducts();
        orderProductsService.deleteFood(orderProducts, dish);
        return "redirect:/user/basket";
    }

}
