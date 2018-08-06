package com.example.petstore.controllers.unit;

import com.example.petstore.models.Category;
import com.example.petstore.rest.seedwork.dto.CategoryDto;

import java.util.ArrayList;
import java.util.List;

public class CategoryFactory {

    public static List<Category> getCategory(){
        List<Category> categories = new ArrayList<>();

        Category category = new Category();
        category.setId("39786f34-8b9f-42bc-ad52-ca7a2fd0c152");
        category.setName("Rat");
        categories.add(category);

        Category category1 = new Category();
        category1.setId("39786f34-8b9f-42bc-ad52-ca7a2fd0c153");
        category1.setName("Rabbit");
        categories.add(category1);

        return categories;
    }

    public Category saveCategory(){

        Category category = new Category();

        category.setId("39786f34-8b9f-42bc-ad52-ca7a2fd0c152");
        category.setName("Rat");

        return category;
    }

    public CategoryDto makeDummyCategoryDto() {
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId("39786f34-8b9f-42bc-ad52-ca7a2fd0c152");
        categoryDto.setName("Rat");

        return categoryDto;
    }
/*
    public static List<CategoryDto> getDtos(){
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        CategoryDto  dto;

        dto = new CategoryDto("39786f34-8b9f-42bc-ad52-ca7a2fd0c152", "Rat");
        categoryDtoList.add(dto);

        dto = new CategoryDto("39786f34-8b9f-42bc-ad52-ca7a2fd0c153", "Rabbit");
        categoryDtoList.add(dto);

        return  categoryDtoList;
    }
*/
}
