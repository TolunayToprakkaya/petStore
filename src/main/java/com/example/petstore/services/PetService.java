package com.example.petstore.services;

import com.example.petstore.models.Pet;

import java.util.List;
import java.util.Optional;

public interface PetService {

    List<Pet> findAll();
    Optional<Pet> findOneById(String id);
    Pet save(Pet pet);
    Pet update(Pet pet);
    void delete(String id);

}
