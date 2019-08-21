package com.robosh.controller;

import com.robosh.entities.User;
import com.robosh.services.OrderService;
import com.robosh.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("user", user);
        model.addAttribute("updateUser", new User());
        model.addAttribute("unpaidOrders", orderService.findByUserAndCheckedAndPaid(user, true, false));
        return "users/user/account";
    }

}
