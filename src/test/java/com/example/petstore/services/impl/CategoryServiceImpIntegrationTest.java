package com.example.petstore.services.impl;

import com.example.petstore.models.Category;
import com.example.petstore.repositories.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.assertj.core.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceImpIntegrationTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl();

    private Category category;

    @Before
    public void prepare(){
        category = new Category();
        category.setId("0b68f388-e199-41f9-a56d-cf8950a7d39e");
        category.setName("Lizard");
    }

    @Test
    public void noDataTest() throws Exception{
        List<Category> categories = categoryServiceImpl.findAll();

        assertThat(categoryServiceImpl.findAll()).isEmpty();
    }

    @Test
    public void findAllTest() throws Exception{
        List<Category> categories = categoryServiceImpl.findAll();
        categories.add(category);

        assertThat(categories.size(), is(1));
        assertThat(categories.get(0).getId(), is("0b68f388-e199-41f9-a56d-cf8950a7d39e"));
    }

    @Test
    public void findOneByIdTest() throws Exception{
        List<Category> categories = new ArrayList<Category>();
        categories.add(category);

        Optional<Category> categoryOptional = categoryServiceImpl.findOneById("0b68f388-e199-41f9-a56d-cf8950a7d39e");

        assertThat(category).isEqualTo(category);
    }

    @Test
    public void saveTest() throws Exception{
        List<Category> categories = new ArrayList<Category>();
        categories.add(category);

        assertThat(categories.size(), is(1));
        assertThat(categories.get(0).getId(), is("0b68f388-e199-41f9-a56d-cf8950a7d39e"));
    }

    @Test
    public void deleteTest() throws Exception{
        List<Category> categories = new ArrayList<Category>();
        categories.add(category);

        categoryServiceImpl.delete("0b68f388-e199-41f9-a56d-cf8950a7d39e");

        assertThat(categoryServiceImpl.findAll()).isEmpty();
    }


}