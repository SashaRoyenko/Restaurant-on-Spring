package com.robosh.services.impl;

import com.robosh.entities.Drink;
import com.robosh.repositories.DrinkRepository;
import com.robosh.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DrinkServiceImpl implements DrinkService {
    private DrinkRepository drinkRepository;

    @Autowired
    public DrinkServiceImpl(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @Override
    public void save(Drink entity) {
        drinkRepository.save(entity);
    }

    @Override
    public List<Drink> findAll() {
        return drinkRepository.findAll();
    }

    @Override
    public Optional<Drink> findById(long id) {
        return drinkRepository.findById(id);
    }

    @Override
    public void delete(Drink entity) {
        drinkRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        drinkRepository.deleteById(id);
    }
}
