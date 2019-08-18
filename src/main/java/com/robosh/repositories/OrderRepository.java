package com.robosh.repositories;

import com.robosh.entities.Order;
import com.robosh.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserAndCheckedAndPaid(User user, boolean checked, boolean paid);
    List<Order> findByChecked(boolean checked);
    List<Order> findByPaid(boolean paid);
}
