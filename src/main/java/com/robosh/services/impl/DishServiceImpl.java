package com.robosh.services.impl;

import com.robosh.entities.Dish;
import com.robosh.repositories.DishRepository;
import com.robosh.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DishServiceImpl implements DishService {
    private DishRepository dishRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public void save(Dish entity) {
        dishRepository.save(entity);
    }

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public Optional<Dish> findById(long id) {
        return dishRepository.findById(id);
    }

    @Override
    public void delete(Dish entity) {
        dishRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        dishRepository.deleteById(id);
    }
}
