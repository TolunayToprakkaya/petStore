package com.example.petStore.services;

import com.example.petStore.models.Pet;

import java.util.List;
import java.util.Optional;

public interface PetService {

    Iterable<Pet> findAll();
    Optional<Pet> findOneById(Integer id);
    Iterable<Pet> findOneByStatus(String status);
    Pet save(Pet pet);
    void delete(Integer id);

}
