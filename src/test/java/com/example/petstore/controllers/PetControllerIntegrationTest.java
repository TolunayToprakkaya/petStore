package com.example.petstore.controllers;

import com.example.petstore.models.Pet;
import com.example.petstore.models.Tag;
import com.example.petstore.services.PetService;
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
@WebMvcTest(value = PetController.class, secure = false)
public class PetControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Qualifier("petService")
    @MockBean
    PetService petService;

    private Pet pet;

    @Before
    public void prepare(){
        pet = new Pet();
        pet.setId("f01dc0db-c456-4770-b6e7-da8e5b8db49e");
        pet.setName("Cymric");
        pet.setPhotoUrl("http://cdn2-www.cattime.com/assets/uploads/gallery/cymric-cats-and-kittens/cymric-cats-kittens-1.jpg");
    }

    @Test
    public void noDataTest() throws Exception{
        List<Pet> pets = petService.findAll();

        assertThat(pets).isEmpty();
    }

    @Test
    public void findAllTest() throws Exception{
        List<Pet> pets = petService.findAll();
        pets.add(pet);

        assertThat(pets.size(), is(1));
        assertThat(pets.get(0).getId(), is("f01dc0db-c456-4770-b6e7-da8e5b8db49e"));
    }

    @Test
    public void findOneTest() throws Exception{
        List<Pet> pets = new ArrayList<Pet>();
        pets.add(pet);

        Optional<Pet> tagOptional = petService.findOneById("f01dc0db-c456-4770-b6e7-da8e5b8db49e");

        assertThat(pet).isEqualTo(pet);
    }

    @Test
    public void saveTest() throws Exception{
        List<Pet> pets = new ArrayList<Pet>();
        pets.add(pet);

        assertThat(pets.size(), is(1));
        assertThat(pets.get(0).getId(), is("f01dc0db-c456-4770-b6e7-da8e5b8db49e"));
    }

    @Test
    public void deleteTest() throws Exception{
        List<Pet> pets = new ArrayList<Pet>();
        pets.add(pet);

        petService.delete("f01dc0db-c456-4770-b6e7-da8e5b8db49e");

        assertThat(petService.findAll().isEmpty());
    }

}