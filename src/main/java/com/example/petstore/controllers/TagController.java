package com.example.petstore.controllers;

import com.example.petstore.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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

    //View
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void view(@PathVariable String id){
        tagService.findOneById(id);
    }

    //Save
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody Tag tag){
        tagService.save(tag);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody Tag tag){
        tagService.update(tag);
    }

    //Delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        tagService.delete(id);
    }
}
