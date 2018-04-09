package com.example.petStore.controllers;

import com.example.petStore.models.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.petStore.services.PetService;

@RestController
@RequestMapping(value = "/pets")
public class PetController {

    @Autowired
    @Qualifier("petService")
    private PetService petService;

    //Find All
    @RequestMapping(method = RequestMethod.GET)
    public void findAll(){
        petService.findAll();
    }

    //View
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void view(@PathVariable String id){
        petService.findOneById(id);
    }

    //Save
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody Pet pet){
        petService.save(pet);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody Pet pet){
        petService.update(pet);
    }

    //Delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        petService.delete(id);
    }

}
