package com.robosh.services;

import com.robosh.entities.User;

public interface UserService extends Service<User>{
    void register(User user);
    User findByEmail(String email);
    User getFromAuthentication();
}
