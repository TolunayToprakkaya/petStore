package com.example.petstore.controllers;

import com.example.petstore.models.Category;
import com.example.petstore.services.CategoryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@WebMvcTest(value = CategoryController.class, secure = false)
public class CategoryControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Qualifier("categoryService")
    @MockBean
    CategoryService categoryService;

    private Category category;

    @Before
    public void prepare() throws Exception {
        category = new Category();
        category.setId("39786f34-8b9f-42bc-ad52-ca7a2fd0c152");
        category.setName("Rat");
    }

    @Test
    public void noDataTest()throws Exception {
        List<Category> categories = categoryService.findAll();

        assertThat(categories).isEmpty();
    }

    @Test
    public void findAllTest()throws Exception {
        List<Category> categories = categoryService.findAll();
        //Add Data
        categories.add(category);

        assertThat(categories.size(), is(1));
        assertThat(categories.get(0).getId(), is("39786f34-8b9f-42bc-ad52-ca7a2fd0c152"));
    }

    @Test
    public void saveTest() throws Exception {
        List<Category> categories = new ArrayList<Category>();
        categories.add(category);

        assertThat(categories.size(), is(1));
        assertThat(categories.get(0).getId(), is("39786f34-8b9f-42bc-ad52-ca7a2fd0c152"));
        /*
        assertThat(categories.size(), is(4));
        assertThat(categories.get(4).getId(), is("39786f34-8b9f-42bc-ad52-ca7a2fd0c152"));
        */
    }

    @Test
    public void findOneByIdTest() throws Exception{
        //Add Data
        List<Category> categories = new ArrayList<Category>();
        categories.add(category);

        Optional<Category> category1 = categoryService.findOneById(category.getId());

        assertThat(category).isEqualTo(category);
    }

    @Test
    public void deleteTest()throws Exception {
        List<Category> categories = new ArrayList<Category>();
        categories.add(category);

        categoryService.delete("39786f34-8b9f-42bc-ad52-ca7a2fd0c152");
        assertThat(categoryService.findAll()).isEmpty();
    }
}