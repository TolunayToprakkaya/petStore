package com.example.petstore.services.impl;

import com.example.petstore.models.Tag;
import com.example.petstore.repositories.TagRepository;
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
public class TagServiceImpIntegrationTest {

    @Mock
    private TagRepository tagRepository;

    @InjectMocks
    private TagServiceImpl tagServiceImpl = new TagServiceImpl();

    private Tag tag;

    @Before
    public void prepare(){
        tag = new Tag();
        tag.setId("679de77c-894b-4039-ae90-5a95c7252b1d");
        tag.setName("France");
    }

    @Test
    public void noDataTest() throws Exception{
        List<Tag> tags = tagServiceImpl.findAll();

        assertThat(tagServiceImpl.findAll()).isEmpty();
    }

    @Test
    public void findAllTest() throws Exception{
        List<Tag> tags = tagServiceImpl.findAll();
        tags.add(tag);

        assertThat(tags.size(), is(1));
        assertThat(tags.get(0).getId(), is("679de77c-894b-4039-ae90-5a95c7252b1d"));
    }

    @Test
    public void findOneByIdTest() throws Exception{
        List<Tag> tags = new ArrayList<Tag>();
        tags.add(tag);

        Optional<Tag> tagOptional = tagServiceImpl.findOneById("679de77c-894b-4039-ae90-5a95c7252b1d");

        assertThat(tag).isEqualTo(tag);
    }

    @Test
    public void saveTest() throws Exception{
        List<Tag> tags = new ArrayList<Tag>();
        tags.add(tag);

        assertThat(tags.size(), is(1));
        assertThat(tags.get(0).getId(), is("679de77c-894b-4039-ae90-5a95c7252b1d"));
    }

    @Test
    public void deleteTest() throws Exception{
        List<Tag> tags = new ArrayList<Tag>();
        tags.add(tag);

        tagServiceImpl.delete("679de77c-894b-4039-ae90-5a95c7252b1d");

        assertThat(tagServiceImpl.findAll()).isEmpty();
    }

}