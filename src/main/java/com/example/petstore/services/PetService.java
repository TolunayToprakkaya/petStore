package com.example.petstore.services;

import com.example.petstore.models.Pet;

import java.util.Optional;

public interface PetService {

    Iterable<Pet> findAll();
    Optional<Pet> findOneById(Integer id);
    Pet save(Pet pet);
    void delete(Integer id);

}
