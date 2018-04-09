package com.example.petStore.services.impl;

import com.example.petStore.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.petStore.repositories.TagRepository;
import com.example.petStore.services.TagService;

import java.util.List;

@Service("tagService")
public class TagServiceImpl implements TagService{

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> findAll() {
        return this.tagRepository.findAll();
    }
}
