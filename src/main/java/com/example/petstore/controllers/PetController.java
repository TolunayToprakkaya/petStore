package com.example.petstore.controllers;

import com.example.petstore.models.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.petstore.services.PetService;

@RestController
@RequestMapping(value = "/pets")
public class PetController {

    @Autowired
    @Qualifier("petService")
    private PetService petService;

    //Find All
    @RequestMapping(value = "")
    public void findAll(){
        petService.findAll();
    }
    //View
    @RequestMapping(value = "/view/{id}")
    public void view(@PathVariable Integer id){
        petService.findOneById(id);
    }
    //Edit
    @RequestMapping(value = "/edit/{id}")
    public void edit(@PathVariable Integer id){
        petService.findOneById(id);
    }
    //Find By Status
    @RequestMapping(value = "/findByStatus")
    public void status(@PathVariable String status){
        petService.findOneByStatus(status);
    }
    //Save
    @RequestMapping(value = "/save")
    public void save(Pet pet){
        petService.save(pet);
    }
    /*
    //Delete
    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable Integer id){
        petService.delete(id);
    }
    */
}
