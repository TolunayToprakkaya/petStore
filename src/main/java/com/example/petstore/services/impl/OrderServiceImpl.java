package com.example.petstore.services.impl;

import com.example.petstore.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.petstore.repositories.OrderRepository;
import com.example.petstore.services.OrderService;

import java.util.Optional;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public Iterable<Order> findAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public Optional<Order> findOneById(Integer orderId) {
        return this.orderRepository.findById(orderId);
    }

    @Override
    public Order save(Order order) {
        return this.orderRepository.save(order);
    }

    @Override
    public void delete(Integer orderId) {
        orderRepository.deleteById(orderId);
    }
}