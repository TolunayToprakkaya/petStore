package com.example.petstore.services;

import com.example.petstore.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findAll();
    Optional<Order> findOneById(String id);
    Order save(Order order);
    Order update(Order order);
    void delete(String id);

}
