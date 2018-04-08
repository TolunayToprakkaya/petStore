package com.example.petstore.services;

import com.example.petstore.models.Order;

import java.util.Optional;

public interface OrderService {

    Iterable<Order> findAll();
    Optional<Order> findOneById(String orderId);
    Order save(Order order);
    void delete(String orderId);

}
