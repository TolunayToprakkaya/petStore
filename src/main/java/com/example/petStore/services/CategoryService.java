package com.example.petStore.services;

import com.example.petStore.models.Category;

import java.util.List;

public interface CategoryService {

    Iterable<Category> findAll();

}
