package com.example.petstore.services;

import com.example.petstore.models.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {

    List<Tag> findAll();
    Optional<Tag> findOneById(String id);
    Tag save(Tag tag);
    Tag update(Tag tag);
    void delete(String id);

}
