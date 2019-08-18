package com.robosh.controller;

import com.robosh.entities.Order;
import com.robosh.entities.User;
import com.robosh.services.OrderService;
import com.robosh.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/account")
    public String account(Model model) {
        List<Order> uncheckedOrders = orderService.findByChecked(false);
        List<Order> unpaidOrders = orderService.findByPaid(false);
        List<Order> paidOrders = orderService.findByPaid(true);
        User user = userService.getFromAuthentication();
        model.addAttribute("user", user);
        model.addAttribute("unpaidOrders", unpaidOrders);
        model.addAttribute("uncheckedOrders", uncheckedOrders);
        model.addAttribute("paidOrders", paidOrders);
        return "users/admin/account";
    }
}
