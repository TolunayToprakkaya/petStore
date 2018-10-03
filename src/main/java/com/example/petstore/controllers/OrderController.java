package com.example.petstore.controllers;

import com.example.petstore.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.petstore.services.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //Find All
    @RequestMapping(method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
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
    @CrossOrigin(origins = "http://localhost:3000")
    public void save(@RequestBody Order order){
        orderService.save(order);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost:3000")
    public void update(@RequestBody Order order){
        orderService.save(order);
    }

    //Patch
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public void patch(@RequestBody Order order){
        orderService.update(order);
    }

    //Delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @CrossOrigin(origins = "http://localhost:3000")
    public void delete(@PathVariable String id){
        orderService.delete(id);
    }

}
