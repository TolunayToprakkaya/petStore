package com.example.petStore.services;

import com.example.petStore.models.Order;

import java.util.Optional;

public interface OrderService {

    Iterable<Order> findAll();
    Optional<Order> findOneById(Integer orderId);
    Order save(Order order);
    void delete(Integer orderId);

}
