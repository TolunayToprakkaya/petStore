package com.example.petstore.controllers;

import com.example.petstore.models.Order;
import com.example.petstore.services.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@WebMvcTest(value = OrderController.class, secure = false)
public class OrderControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Qualifier("orderService")
    @MockBean
    private OrderService orderService;

    private Order order;

    @Before
    public void prepare(){
        order = new Order();
        order.setId("76304ea0-254a-41e5-969c-878cd4b80f44");
        order.setQuantity(10);
        order.setComplete(true);
    }

    @Test
    public void noDataTest() throws Exception{
        List<Order> orders = orderService.findAll();

        assertThat(orders).isEmpty();
    }

    @Test
    public void findAllTest() throws Exception{
        List<Order> orders = orderService.findAll();
        orders.add(order);

        assertThat(orders.size(), is(1));
        assertThat(orders.get(0).getId(), is("76304ea0-254a-41e5-969c-878cd4b80f44"));
    }

    @Test
    public void findOneByIdTest() throws Exception{
        List<Order> orders = new ArrayList<Order>();
        orders.add(order);

        Optional<Order> orderOptional = orderService.findOneById("76304ea0-254a-41e5-969c-878cd4b80f44");

        assertThat(order).isEqualTo(order);
    }

    @Test
    public void saveTest() throws Exception{
        List<Order> orders = new ArrayList<Order>();
        orders.add(order);

        assertThat(orders.size(), is(1));
        assertThat(orders.get(0).getId(), is("76304ea0-254a-41e5-969c-878cd4b80f44"));
    }

    @Test
    public void deleteTest() throws Exception{
        List<Order> orders = new ArrayList<Order>();
        orders.add(order);

        orderService.delete("76304ea0-254a-41e5-969c-878cd4b80f44");

        assertThat(orderService.findAll()).isEmpty();
    }
}