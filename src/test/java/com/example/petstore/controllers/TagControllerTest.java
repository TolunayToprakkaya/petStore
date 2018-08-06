package com.example.petstore.controllers;

import com.example.petstore.models.Tag;
import com.example.petstore.services.TagService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@WebMvcTest(value = TagController.class, secure = false)
public class TagControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Qualifier("tagService")
    @MockBean
    TagService tagService;

    private Tag tag, tag1;

    @Before
    public void prepare(){
        tag = new Tag();
        tag1 = new Tag();

        tag.setId("17419e6e-2a0a-4732-9198-69fbe51596f3");
        tag.setName("Turkey");

        tag1.setId("17419e6e-2a0a-4732-9198-69fbe51596f4");
        tag1.setName("France");
    }

    @Test
    public void noDataTest() throws Exception{
        List<Tag> tags = tagService.findAll();

        assertThat(tags).isEmpty();
    }

    @Test
    public void findAllTest() throws Exception{
        List<Tag> tags = new ArrayList<Tag>();
        tags.add(tagService.save(tag));
        tags.add(tagService.save(tag1));

        assertThat(tags.size(), is(2));
        //assertThat(tags.get(0).getId(), is("17419e6e-2a0a-4732-9198-69fbe51596f3"));
    }

    @Test
    public void findOneTest() throws Exception{
        List<Tag> tags = new ArrayList<Tag>();
        tags.add(tag);

        Optional<Tag> tagOptional = tagService.findOneById("17419e6e-2a0a-4732-9198-69fbe51596f3");

        assertThat(tag).isEqualTo(tag);
    }

    @Test
    public void saveTest() throws Exception{
        List<Tag> tags = new ArrayList<Tag>();
        tags.add(tag);

        assertThat(tags.size(), is(1));
        assertThat(tags.get(0).getId(), is("17419e6e-2a0a-4732-9198-69fbe51596f3"));
    }

    @Test
    public void deleteTest() throws Exception{
        List<Tag> tags = new ArrayList<Tag>();
        tags.add(tag);

        tagService.delete("17419e6e-2a0a-4732-9198-69fbe51596f3");

        assertThat(tagService.findAll().isEmpty());
    }
/*
    @Test
    public void findOneTest() throws Exception {
        given(tagService.findOneById("17419e6e-2a0a-4732-9198-69fbe51596f3")).willReturn(java.util.Optional.ofNullable(tag));
        mockMvc.perform(get("/tags/17419e6e-2a0a-4732-9198-69fbe51596f3").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
                    //.andExpect(jsonPath("$.id", is("17419e6e-2a0a-4732-9198-69fbe51596f3")))
                    //.andExpect(jsonPath("$.name", is("Turkey")));
    }

    @Test
    public void tagNotFoundTest() throws Exception {
        mockMvc.perform(get("/tag/66721af4-8ed0-4663-a2a6-a7762664c337").accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }

    @Test
    public void saveTagTest() throws Exception{
        List<Tag> tags = new ArrayList<Tag>();
        tags.add(tag);

        given(tagService.findAll()).willReturn(tags);
        mockMvc.perform(get("/tags").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
                    //.andExpect(jsonPath("$[0].id", is("17419e6e-2a0a-4732-9198-69fbe51596f3")))
                    //.andExpect(jsonPath("$[1].name", is("Turkey")));
    }
*/
}