package com.example.petStore.controllers;

import com.example.petStore.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.petStore.services.TagService;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    @Qualifier("tagService")
    private TagService tagService;

    //Find All
    @RequestMapping(value = "")
    public List<Tag> findAll(){
        return tagService.findAll();
    }
}
