package com.example.petStore.controllers;

import com.example.petStore.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.petStore.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    @Qualifier("categoryService")
    private CategoryService categoryService;

    //Find All
    @RequestMapping(value = "")
    public List<Category> findAll(){
        return categoryService.findAll();
    }

}
