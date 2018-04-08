package com.example.petStore.services.impl;

import com.example.petStore.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.petStore.repositories.CategoryRepository;
import com.example.petStore.services.CategoryService;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return this.categoryRepository.findAll();
    }
}
