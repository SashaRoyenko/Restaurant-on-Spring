package com.robosh.services;

import com.robosh.entities.Order;
import com.robosh.entities.OrderProducts;
import com.robosh.entities.User;

import java.util.List;

public interface OrderService extends Service<Order> {
    void createOrder(OrderProducts orderProducts, String address);
    List<Order> findByUserAndCheckedAndPaid(User user, boolean checked, boolean paid);
    List<Order> findByChecked(boolean checked);
    List<Order> findByPaid(boolean paid);
}
