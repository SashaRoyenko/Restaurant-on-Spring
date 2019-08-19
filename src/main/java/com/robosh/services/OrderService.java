package com.robosh.services;

import com.robosh.entities.Order;
import com.robosh.entities.OrderProducts;
import com.robosh.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService extends Service<Order> {
    void createOrder(OrderProducts orderProducts, String address);

    List<Order> findByUserAndCheckedAndPaid(User user, boolean checked, boolean paid);

    List<Order> findByChecked(boolean checked);

    List<Order> findByPaid(boolean paid);

    Page<Order> findByChecked(boolean checked, Pageable pageable);

    Page<Order> findByPaid(boolean paid, Pageable pageable);
}
