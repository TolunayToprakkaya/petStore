package com.example.petstore.controllers;

import com.example.petstore.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.petstore.services.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //Find All
    @RequestMapping(value = "")
    public void findAll(){
        orderService.findAll();
    }
    //Fimd All
    @RequestMapping(value = "/order")
    public void order(){
        orderService.findAll();
    }
    //Find One By OrderId
    @RequestMapping(value = "/order/{orderId}")
    public void findByOrder(@PathVariable Integer orderId){
        orderService.findOneById(orderId);
    }
    //Save
    @RequestMapping(value = "/order/save")
    public void save(Order order){
        orderService.save(order);
    }
    /*
    //Delete One By OrderId
    @RequestMapping(value = "/order/{orderId}")
    public void delete(@PathVariable Integer orderId){
        storeService.delete(orderId);
    }
    */
}
