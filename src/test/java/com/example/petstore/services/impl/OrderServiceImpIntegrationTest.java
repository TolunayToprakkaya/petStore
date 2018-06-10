package com.example.petstore.services.impl;

import com.example.petstore.models.Order;
import com.example.petstore.repositories.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.assertj.core.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImpIntegrationTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderServiceImpl = new OrderServiceImpl();

    private Order order;

    @Before
    public void prepare(){
        order = new Order();
        order.setId("8669270c-a136-434c-9db3-2a4c383f0853");
        order.setQuantity(10);
        order.setComplete(true);
    }

    @Test
    public void noDataTest() throws Exception{
        List<Order> orders = orderServiceImpl.findAll();

        assertThat(orderServiceImpl.findAll()).isEmpty();
    }

    @Test
    public void findAllTest() throws Exception{
        List<Order> orders = orderServiceImpl.findAll();
        orders.add(order);

        assertThat(orders.size(), is(1));
        assertThat(orders.get(0).getId(), is("8669270c-a136-434c-9db3-2a4c383f0853"));
    }

    @Test
    public void findOneByIdTest() throws Exception{
        List<Order> orders = new ArrayList<Order>();
        orders.add(order);

        Optional<Order> orderOptional = orderServiceImpl.findOneById("8669270c-a136-434c-9db3-2a4c383f0853");

        assertThat(order).isEqualTo(order);
    }

    @Test
    public void saveTest() throws Exception{
        List<Order> orders = new ArrayList<Order>();
        orders.add(order);

        assertThat(orders.size(), is(1));
        assertThat(orders.get(0).getId(), is("8669270c-a136-434c-9db3-2a4c383f0853"));
    }

    @Test
    public void deleteTest() throws Exception{
        List<Order> orders = new ArrayList<Order>();
        orders.add(order);

        orderServiceImpl.delete("8669270c-a136-434c-9db3-2a4c383f0853");

        assertThat(orderServiceImpl.findAll()).isEmpty();
    }

}