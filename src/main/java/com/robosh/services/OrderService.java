package com.robosh.services;

import com.robosh.entities.Order;
import com.robosh.entities.OrderProducts;

public interface OrderService extends Service<Order> {
    void createOrder(OrderProducts orderProducts, String address);
}
