package com.example.petStore.controllers;

import com.example.petStore.models.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.petStore.services.OrderService;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //Find All
    @RequestMapping(method = RequestMethod.GET)
    public List<Order> findAll(){
        return orderService.findAll();
    }

    //View
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void view(@PathVariable String id){
        orderService.findOneById(id);
    }

    //Save
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody Order order){
        orderService.save(order);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody Order order){
        orderService.save(order);
    }

    //Delete
    @RequestMapping(value = "/{orderId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        orderService.delete(id);
    }

}
