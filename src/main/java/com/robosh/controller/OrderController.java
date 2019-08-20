package com.robosh.controller;

import com.robosh.entities.Order;
import com.robosh.entities.OrderProducts;
import com.robosh.services.OrderProductsService;
import com.robosh.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/buy/{orderProducts}")
    public String order(@PathVariable OrderProducts orderProducts, @RequestParam String address) {
        orderService.createOrder(orderProducts, address);
        return "redirect:/menu";
    }

    @PutMapping("/pay/{order}")
    public String pay(@PathVariable Order order) {
        order.setPaid(true);
        orderService.save(order);
        return "redirect:/user/account";
    }

    @PutMapping("/confirm/{order}")
    public String confirm(@PathVariable Order order) {
        order.setChecked(true);
        orderService.save(order);
        return "redirect:/admin/account";
    }
}
