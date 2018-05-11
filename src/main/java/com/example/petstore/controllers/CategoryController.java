package com.example.petstore.controllers;

import com.example.petstore.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.petstore.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    @Qualifier("categoryService")
    private CategoryService categoryService;

    //Find All
    @RequestMapping(method = RequestMethod.GET)
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    //View
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void view(@PathVariable String id){
        categoryService.findOneById(id);
    }

    //Save
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody Category category){
        categoryService.save(category);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody Category category){
        categoryService.update(category);
    }

    //Patch
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public void patch(@RequestBody Category category){
        categoryService.update(category);
    }

    //Delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        categoryService.delete(id);
    }

}
