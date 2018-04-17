package com.example.petstore.services.impl;

import com.example.petstore.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.petstore.repositories.OrderRepository;
import com.example.petstore.services.OrderService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public Optional<Order> findOneById(String id) {
        return this.orderRepository.findById(id);
    }

    @Transactional
    @Override
    public Order save(Order order) {
        return this.orderRepository.save(order);
    }

    @Transactional
    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    @Override
    public void delete(String id) {
        orderRepository.deleteById(id);
    }


}
