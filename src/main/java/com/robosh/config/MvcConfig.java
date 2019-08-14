package com.robosh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/menu").setViewName("menu");
        registry.addViewController("/about").setViewName("about");
        registry.addViewController("/registration").setViewName("registration");
        registry.addViewController("/user/basket").setViewName("users/user/basket");
        registry.addViewController("/user/account").setViewName("users/user/account");
        registry.addViewController("/admin/account").setViewName("users/admin/account");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
    }


}