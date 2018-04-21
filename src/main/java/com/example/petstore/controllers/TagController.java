package com.example.petstore.controllers;

import com.example.petstore.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.petstore.services.TagService;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    @Qualifier("tagService")
    private TagService tagService;

    //Find All
    @RequestMapping(method = RequestMethod.GET)
    public List<Tag> findAll(){
        return tagService.findAll();
    }
}
