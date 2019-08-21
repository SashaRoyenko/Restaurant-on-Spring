package com.robosh.services.impl;

import com.robosh.entities.Dish;
import com.robosh.entities.Drink;
import com.robosh.entities.OrderProducts;
import com.robosh.entities.User;
import com.robosh.repositories.OrderProductsRepository;
import com.robosh.services.OrderProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderProductsServiceImpl implements OrderProductsService {

    private OrderProductsRepository orderProductsRepository;

    @Autowired
    public OrderProductsServiceImpl(OrderProductsRepository orderProductsRepository) {
        this.orderProductsRepository = orderProductsRepository;
    }

    @Override
    public void save(OrderProducts entity) {
        orderProductsRepository.save(entity);
    }

    @Override
    public List<OrderProducts> findAll() {
        return orderProductsRepository.findAll();
    }

    @Override
    public Optional<OrderProducts> findById(long id) {
        return orderProductsRepository.findById(id);
    }

    @Override
    public void delete(OrderProducts entity) {
        orderProductsRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        orderProductsRepository.deleteById(id);
    }


    @Override
    public Optional<OrderProducts> findByUser(User user) {
        return orderProductsRepository.findByUser(user);
    }

    @Override
    public void addFood(OrderProducts orderProducts, Object food) {
        if (food instanceof Dish) {
            orderProducts.addDish((Dish) food);
            orderProductsRepository.save(orderProducts);
        } else if (food instanceof Drink) {
            orderProducts.addDrink((Drink) food);
            orderProductsRepository.save(orderProducts);
        }
    }

    @Override
    public float getTotalPrice(OrderProducts orderProducts) {
        float price =
                orderProducts.getDishList()
                        .stream()
                        .map(Dish::getPrice)
                        .reduce(0f, Float::sum);
        price += orderProducts.getDrinkList()
                .stream()
                .map(Drink::getPrice)
                .reduce(0f, Float::sum);
        System.out.println(price);
        return price;
    }

    @Override
    public void deleteFood(OrderProducts orderProducts, Object food) {
        if (food instanceof Dish) {
            orderProducts.deleteDish((Dish) food);
            orderProductsRepository.save(orderProducts);
        } else if (food instanceof Drink) {
            orderProducts.deleteDrink((Drink) food);
            orderProductsRepository.save(orderProducts);
        }
    }

    @Override
    @Transactional
    public OrderProducts getOrderProductsForUser(User user) {

        return orderProductsRepository.findByUser(user).orElseGet(() ->
                {
                    orderProductsRepository.save(
                            OrderProducts.builder()
                                    .user(user)
                                    .dishList(new ArrayList<>())
                                    .drinkList(new ArrayList<>())
                                    .build());
                    return orderProductsRepository.findByUser(user).get();
                }

        );
    }


}
