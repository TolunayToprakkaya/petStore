package com.example.petstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.petstore.services.TagService;

@RestController
@RequestMapping(value = "/tags")
public class TagController {

    @Autowired
    @Qualifier("tagService")
    private TagService tagService;

    //Find All
    @RequestMapping(value = "")
    public void findAll(){
        tagService.findAll();
    }
}
