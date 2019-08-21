package com.robosh.controller;

import com.robosh.entities.User;
import com.robosh.repositories.DishRepository;
import com.robosh.repositories.DrinkRepository;
import com.robosh.services.OrderService;
import com.robosh.services.UserService;
import com.robosh.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;

import javax.websocket.server.PathParam;

@Controller
public class PagesController {
    private DishRepository dishRepository;
    private DrinkRepository drinkRepository;
    private UserService userService;
    private UserValidator userValidator;
    private OrderService orderService;

    @Autowired
    public PagesController(DishRepository dishRepository, DrinkRepository drinkRepository, UserService userService, UserValidator userValidator, OrderService orderService) {
        this.dishRepository = dishRepository;
        this.drinkRepository = drinkRepository;
        this.userService = userService;
        this.userValidator = userValidator;
        this.orderService = orderService;
    }


    @GetMapping("/menu")
    public void menu(Model model) {
        model.addAttribute("drinks", drinkRepository.findAll());
        model.addAttribute("dishes", dishRepository.findAll());
    }

    @GetMapping("/user")
    public String getUser() {
        return "redirect:/" + userService.getFromAuthentication().getRole().toString().toLowerCase() + "/account";
    }

    @PutMapping("/user/{updateUser}")
    public String updateUser(@ModelAttribute User updateUser, BindingResult bindingResult, Model model) {

        userValidator.validate(updateUser, bindingResult);
        User authUser = userService.getFromAuthentication();

        if (bindingResult.hasErrors()) {
            model.addAttribute("user", authUser);
            model.addAttribute("updateUser", updateUser);
            model.addAttribute("unpaidOrders", orderService.findByUserAndCheckedAndPaid(authUser, true, false));
            return "users/user/account";
        }

        return userService.update(updateUser) ? "redirect:/login?logout=true" : "redirect:/user";

    }

}
