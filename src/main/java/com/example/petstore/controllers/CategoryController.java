package com.example.petstore.controllers;

import com.example.petstore.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

}
