package com.robosh.controller;

import com.robosh.entities.User;
import com.robosh.services.OrderService;
import com.robosh.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.data.domain.Pageable;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private OrderService orderService;
    private UserServiceImpl userService;

    @Autowired
    public AdminController(OrderService orderService, UserServiceImpl userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/account")
    public String account(Model model,
                          @PageableDefault(sort = {"id"},
                                  direction = Sort.Direction.DESC,
                                  size = 5)
                                  Pageable pageable) {
        model.addAttribute("user", userService.getFromAuthentication());
        model.addAttribute("updateUser", new User());
        model.addAttribute("uncheckedOrders", orderService.findByChecked(false, pageable));
        model.addAttribute("paidOrders", orderService.findByPaid(false, pageable));
        return "users/admin/account";
    }
}
