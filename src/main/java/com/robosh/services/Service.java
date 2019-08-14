package com.robosh.services;

import com.robosh.entities.User;

import java.util.List;
import java.util.Optional;

public interface Service<T> {
    void save(T entity);
    List<T> findAll();
    Optional<T> findById(long id);
    void delete(T entity);
    void deleteById(long id);
}
