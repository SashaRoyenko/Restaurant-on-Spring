package com.robosh.services;

import com.robosh.entities.OrderProducts;
import com.robosh.entities.User;

public interface OrderProductsService extends Service<OrderProducts> {
    OrderProducts findByUser(User user);
    void addFood(OrderProducts orderProducts, Object food);
    float getTotalPrice(OrderProducts orderProducts);
    void deleteFood(OrderProducts orderProducts, Object food);
}
