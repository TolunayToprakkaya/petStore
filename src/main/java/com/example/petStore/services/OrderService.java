package com.example.petStore.services;

import com.example.petStore.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findAll();
    Optional<Order> findOneById(String id);
    Order save(Order order);
    Order update(Order order);
    void delete(String id);

}
