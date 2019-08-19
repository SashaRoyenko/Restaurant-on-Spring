package com.robosh.repositories;

import com.robosh.entities.Order;
import com.robosh.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserAndCheckedAndPaid(User user, boolean checked, boolean paid);
    List<Order> findByChecked(boolean checked);
    Page<Order> findByChecked(boolean checked, Pageable pageable);
    List<Order> findByPaid(boolean paid);
    Page<Order> findByPaid(boolean paid, Pageable pageable);
}
