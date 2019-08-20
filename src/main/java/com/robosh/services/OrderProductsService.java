package com.robosh.services;

import com.robosh.entities.OrderProducts;
import com.robosh.entities.User;

import java.util.Optional;

public interface OrderProductsService extends Service<OrderProducts> {
    Optional<OrderProducts> findByUser(User user);
    void addFood(OrderProducts orderProducts, Object food);
    float getTotalPrice(OrderProducts orderProducts);
    void deleteFood(OrderProducts orderProducts, Object food);
    OrderProducts getOrderProductsForUser(User user);
}
