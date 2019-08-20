package com.robosh.services.impl;

import com.robosh.entities.Order;
import com.robosh.entities.OrderProducts;
import com.robosh.entities.User;
import com.robosh.repositories.OrderRepository;
import com.robosh.services.OrderProductsService;
import com.robosh.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private OrderProductsService orderProductsService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderProductsService orderProductsService) {
        this.orderRepository = orderRepository;
        this.orderProductsService = orderProductsService;
    }

    @Override
    public void save(Order entity) {
        orderRepository.save(entity);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
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
    @Transactional
    public void createOrder(OrderProducts orderProducts, String address) {
        orderRepository.save(
                Order.builder()
                        .address(address)
                        .user(orderProducts.getUser())
                        .bill(orderProductsService.getTotalPrice(orderProducts))
                        .build());
        orderProductsService.delete(orderProducts);
    }

    @Override
    public List<Order> findByUserAndCheckedAndPaid(User user, boolean checked, boolean paid) {
        return orderRepository.findByUserAndCheckedAndPaid(user, checked, paid);
    }

    @Override
    public List<Order> findByChecked(boolean checked) {
        return orderRepository.findByChecked(checked);
    }

    @Override
    public List<Order> findByPaid(boolean paid) {
        return orderRepository.findByPaid(paid);
    }

    @Override
    public Page<Order> findByChecked(boolean checked, Pageable pageable) {
        return orderRepository.findByChecked(checked, pageable);
    }

    @Override
    public Page<Order> findByPaid(boolean paid, Pageable pageable) {
        return orderRepository.findByPaid(paid, pageable);
    }
}
