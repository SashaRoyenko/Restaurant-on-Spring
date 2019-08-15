package com.robosh.services.impl;

import com.robosh.entities.Order;
import com.robosh.entities.OrderProducts;
import com.robosh.repositories.OrderRepository;
import com.robosh.services.OrderProductsService;
import com.robosh.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void save(Order entity) {
        orderRepository.save(entity);
    }

    @Override
    public List<Order> findAll() {
        return  orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void delete(Order entity) {
        orderRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void createOrder(OrderProducts orderProducts, String address) {
        OrderProductsService orderProductsService = new OrderProductsServiceImpl();
        Order order = Order.builder()
                .address(address)
                .user(orderProducts.getUser())
                .bill(orderProductsService.getTotalPrice(orderProducts))
                .build();
        orderRepository.save(order);
        orderProductsService.delete(orderProducts);
    }
}
