package com.example.petstore.controllers;

import com.example.petstore.controllers.unit.CategoryFactory;
import com.example.petstore.factory.JsonFileLoader;
import com.example.petstore.models.Category;
import com.example.petstore.rest.seedwork.dto.CategoryDto;
import com.example.petstore.services.CategoryService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.springframework.http.MediaType;

import java.util.Arrays;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest{

    @Mock
    CategoryService categoryService;

    @InjectMocks
    CategoryController categoryController;

    private  MockMvc mockMvc;

    private Gson gson = new Gson();

    private CategoryFactory categoryFactory;

//  private Category category, category1;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
        categoryFactory = new CategoryFactory();
/*
        category = new Category();
        category1 = new Category();

        category.setId("39786f34-8b9f-42bc-ad52-ca7a2fd0c152");
        category.setName("Rat");

        category1.setId("39786f34-8b9f-42bc-ad52-ca7a2fd0c153");
        category1.setName("Rabbit");
*/
    }

    @Test
    public void testNoData()throws Exception {
        List<Category> categories = Arrays.asList();

        Mockito.when(categoryService.findAll()).thenReturn(categories);

        assertThat(categoryService.findAll().size(), is(0));
    }

    @Test
    public void testFindAll() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/categories").accept(MediaType.ALL);

        List<Category> categories = categoryFactory.getCategory();

        when(categoryService.findAll()).thenReturn(categories);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        JsonElement json = JsonFileLoader.getJsonForFile("example_categories");

        assertEquals(json.toString(), response.getContentAsString());

        //assertEquals(gson.toJson(json), response.getContentAsString());

        //assertThat(categoryService.findAll().size(), is(2));


    }

    @Test
    public void testSave() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/categories").accept(MediaType.APPLICATION_JSON);

        Category category = categoryFactory.saveCategory();

        when(categoryService.save(category)).thenReturn(category);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        JsonElement json = JsonFileLoader.getJsonForFile("example_saveCategories");
        assertEquals(json.toString(), response.getContentAsString());
    }


}
/*
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@WebMvcTest(value = CategoryController.class, secure = false)
public class CategoryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Qualifier("categoryService")
    @MockBean
    CategoryService categoryService;

    private Category category, category1;

    @Before
    public void prepare() throws Exception {
        category = new Category();
        category1 = new Category();

        category.setId("39786f34-8b9f-42bc-ad52-ca7a2fd0c152");
        category.setName("Rat");

        category1.setId("39786f34-8b9f-42bc-ad52-ca7a2fd0c153");
        category1.setName("Rabbit");
    }

    @Test
    public void noDataTest()throws Exception {
        List<Category> categories = Arrays.asList();

        Mockito.when(categoryService.findAll()).thenReturn(categories);

        assertThat(categoryService.findAll().size(), is(0));
    }


    @Test
    public void findAllTest()throws Exception {
        List<Category> categories = Arrays.asList(category, category1);

        Mockito.when(categoryService.findAll()).thenReturn(categories);

        assertThat(categoryService.findAll().size(), is(2));
    }

    @Test
    public void saveTest() throws Exception {

        Mockito.when(categoryService.save(category)).thenReturn(category);
        Category saveCategory = categoryService.save(category);
        assertThat(saveCategory).isEqualTo(category);

        Mockito.when(categoryService.save(category1)).thenReturn(category1);
        Category saveCategory1 = categoryService.save(category1);
        assertThat(saveCategory1).isEqualTo(category1);
    }

    @Test
    public void findOneByIdTest() throws Exception{

        Mockito.when(categoryService.findOneById("39786f34-8b9f-42bc-ad52-ca7a2fd0c152")).thenReturn(Optional.of(category));
        Optional<Category> retrievedCategory = categoryService.findOneById("39786f34-8b9f-42bc-ad52-ca7a2fd0c152");
        assertThat(retrievedCategory).isEqualTo(category);

    }

    @Test
    public void deleteTest()throws Exception {
        List<Category> categories = Arrays.asList(category, category1);

        Mockito.when(categoryService.findAll()).thenReturn(categories);

        Mockito.doNothing().when(categoryService).delete("39786f34-8b9f-42bc-ad52-ca7a2fd0c152");
        categoryService.delete("39786f34-8b9f-42bc-ad52-ca7a2fd0c152");

        verify(categoryService, times(1)).delete("39786f34-8b9f-42bc-ad52-ca7a2fd0c152");
    }

}*/


/*
    @Test
    @Ignore
    public void testFindOneById() throws Exception {
        Mockito.when(categoryService.findOneById("39786f34-8b9f-42bc-ad52-ca7a2fd0c152")).thenReturn(Optional.of(category));
        //Category retrievedCategory = categoryService.findOneById(category.getId());
        Optional<Category> retrievedCategory = categoryService.findOneById(category.getId());
        assertEquals(retrievedCategory, category);
    }

    @Test
    public void saveTest() throws Exception {

        Mockito.when(categoryService.save(category)).thenReturn(category);
        Category saveCategory = categoryService.save(category);
        assertEquals(saveCategory, category);

        Mockito.when(categoryService.save(category1)).thenReturn(category1);
        Category saveCategory1 = categoryService.save(category1);
        assertEquals(saveCategory1, category1);
    }

    @Test
    public void deleteTest()throws Exception {
        Mockito.doNothing().when(categoryService).delete(category.getId());
        categoryService.delete(category.getId());

        verify(categoryService, times(1)).delete(category.getId());
    }
 */