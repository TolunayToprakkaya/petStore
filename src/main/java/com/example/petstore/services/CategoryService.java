package com.example.petstore.services;

import com.example.petstore.models.Category;

public interface CategoryService {

    Iterable<Category> findAll();

}
