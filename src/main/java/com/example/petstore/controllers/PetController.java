package com.example.petstore.controllers;

import com.example.petstore.models.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.petstore.services.PetService;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    @Qualifier("petService")
    private PetService petService;

    //Find All
    @RequestMapping(method = RequestMethod.GET)
    public List<Pet> findAll(){
        return petService.findAll();
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

    //Patch
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public void patch(@RequestBody Pet pet){
        petService.update(pet);
    }

    //Delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        petService.delete(id);
    }

}
