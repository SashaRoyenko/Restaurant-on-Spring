package com.robosh.controller;

import com.robosh.entities.OrderProducts;
import com.robosh.services.OrderProductsService;
import com.robosh.services.OrderService;
import com.robosh.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private UserService userService;

    @Autowired
    private
    OrderProductsService orderProductsService;


    @Autowired
    private
    OrderService orderService;

    @PostMapping("/buy/{orderProducts}")
    public String order(@PathVariable OrderProducts orderProducts, @RequestParam String address){
        orderService.createOrder(orderProducts, address);
        return "redirect:/menu";
    }
}
