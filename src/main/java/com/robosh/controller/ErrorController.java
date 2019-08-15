package com.robosh.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/error")
public class ErrorController {


    @GetMapping(value = "/403")
    public String error403() {
        return "error/403";
    }



}