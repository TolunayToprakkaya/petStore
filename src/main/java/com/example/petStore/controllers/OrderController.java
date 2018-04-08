package com.example.petStore.controllers;

import com.example.petStore.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.petStore.services.OrderService;

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
    public void findByOrder(@PathVariable String orderId){
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
