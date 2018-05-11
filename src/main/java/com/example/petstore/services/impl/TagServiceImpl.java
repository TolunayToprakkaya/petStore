package com.example.petstore.services.impl;

import com.example.petstore.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.petstore.repositories.TagRepository;
import com.example.petstore.services.TagService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("tagService")
public class TagServiceImpl implements TagService{

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> findAll() {
        return this.tagRepository.findAll();
    }

    @Override
    public Optional<Tag> findOneById(String id) {
        return this.tagRepository.findById(id);
    }

    @Transactional
    @Override
    public Tag save(Tag tag) {
        return this.tagRepository.save(tag);
    }

    @Transactional
    @Override
    public Tag update(Tag tag) {
        return this.tagRepository.save(tag);
    }

    @Transactional
    @Override
    public void delete(String id) {
        tagRepository.deleteById(id);
    }
}
