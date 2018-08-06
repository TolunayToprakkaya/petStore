package com.example.petstore.rest.seedwork.dto;

import com.example.petstore.models.Category;
import lombok.*;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class CategoryDto{
    @Getter @Setter String id;
    @Getter @Setter String name;
    /*
    private String id;
    private String name;

    private static CategoryDto fromCategory(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.fill(category);
        return categoryDto;
    }

    public void fill(Category category){
        if(category != null){
            setId(category.getId());
            setName((category.getName()));
        }
    }
    */
}
