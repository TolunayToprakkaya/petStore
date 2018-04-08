package com.example.petstore.services;

import com.example.petstore.models.Tag;

public interface TagService {

    Iterable<Tag> findAll();

}
