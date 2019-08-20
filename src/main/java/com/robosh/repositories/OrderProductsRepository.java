package com.robosh.repositories;

import com.robosh.entities.Dish;
import com.robosh.entities.Drink;
import com.robosh.entities.OrderProducts;
import com.robosh.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderProductsRepository extends JpaRepository<OrderProducts, Long> {
    Optional<OrderProducts> findByUser(User user);
}
