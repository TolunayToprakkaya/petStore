package com.example.petStore.services;

import com.example.petStore.models.Tag;

import java.util.List;

public interface TagService {

    Iterable<Tag> findAll();

}
