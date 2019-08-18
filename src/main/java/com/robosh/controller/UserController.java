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

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/account")
    public String account(Model model) {
        User user = userService.getFromAuthentication();
        List<Order> unpaidOrders = orderService.findByUserAndCheckedAndPaid(user, true, false);
        System.out.println(unpaidOrders);
        model.addAttribute("user", user);
        model.addAttribute("unpaidOrders", unpaidOrders);
        return "users/user/account";
    }

}
