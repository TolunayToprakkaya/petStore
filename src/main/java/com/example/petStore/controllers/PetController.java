package com.example.petStore.controllers;

import com.example.petStore.models.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.petStore.services.PetService;

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
    public void view(@PathVariable String id){
        petService.findOneById(id);
    }
    //Edit
    @RequestMapping(value = "/edit/{id}")
    public void edit(@PathVariable String id){
        petService.findOneById(id);
    }
    //Save
    @RequestMapping(value = "/save")
    public void save(Pet pet){
        petService.save(pet);
    }
    /*
    //Delete
    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable String id){
        petService.delete(id);
    }
    */
}
