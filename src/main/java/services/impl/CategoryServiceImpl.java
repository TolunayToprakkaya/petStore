package services.impl;

import models.Category;
import org.springframework.stereotype.Service;
import repositories.CategoryRepository;
import services.CategoryService;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

}
