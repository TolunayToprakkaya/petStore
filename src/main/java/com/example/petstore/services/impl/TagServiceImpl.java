package com.example.petstore.services.impl;

import com.example.petstore.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.petstore.repositories.TagRepository;
import com.example.petstore.services.TagService;

@Service("tagService")
public class TagServiceImpl implements TagService{

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Iterable<Tag> findAll() {
        return this.tagRepository.findAll();
    }
}
