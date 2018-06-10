package com.example.petstore.services.impl;

import com.example.petstore.models.Pet;
import com.example.petstore.repositories.PetRepository;
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
public class PetServiceImpIntegrationTest {

    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private PetServiceImpl petServiceImpl = new PetServiceImpl();

    private Pet pet;

    @Before
    public void prepare(){
        pet = new Pet();
        pet.setId("f7b2dbd3-1dec-43ad-b192-cb8f7784fc58");
        pet.setName("Nebelung");
        pet.setPhotoUrl("http://cdn3-www.cattime.com/assets/uploads/gallery/nebelung-cats-and-kittens/nebelung-cats-kittens-3.jpg");
    }

    @Test
    public void noDataTest() throws Exception{
        List<Pet> tags = petServiceImpl.findAll();

        assertThat(petServiceImpl.findAll()).isEmpty();
    }

    @Test
    public void findAllTest() throws Exception{
        List<Pet> pets = petServiceImpl.findAll();
        pets.add(pet);

        assertThat(pets.size(), is(1));
        assertThat(pets.get(0).getId(), is("f7b2dbd3-1dec-43ad-b192-cb8f7784fc58"));
    }

    @Test
    public void findOneByIdTest() throws Exception{
        List<Pet> pets = new ArrayList<Pet>();
        pets.add(pet);

        Optional<Pet> petOptional = petServiceImpl.findOneById("f7b2dbd3-1dec-43ad-b192-cb8f7784fc58");

        assertThat(pet).isEqualTo(pet);
    }

    @Test
    public void saveTest() throws Exception{
        List<Pet> pets = new ArrayList<Pet>();
        pets.add(pet);

        assertThat(pets.size(), is(1));
        assertThat(pets.get(0).getId(), is("f7b2dbd3-1dec-43ad-b192-cb8f7784fc58"));
    }

    @Test
    public void deleteTest() throws Exception{
        List<Pet> pets = new ArrayList<Pet>();
        pets.add(pet);

        petServiceImpl.delete("f7b2dbd3-1dec-43ad-b192-cb8f7784fc58");

        assertThat(petServiceImpl.findAll()).isEmpty();
    }

}