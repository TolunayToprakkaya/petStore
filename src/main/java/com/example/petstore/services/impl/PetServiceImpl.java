package com.example.petstore.services.impl;

import com.example.petstore.models.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.petstore.repositories.PetRepository;
import com.example.petstore.services.PetService;

import java.util.Optional;

@Service("petService")
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;


    @Override
    public Iterable<Pet> findAll() {
        return this.petRepository.findAll();
    }

    @Override
    public Optional<Pet> findOneById(Integer id) {
        return this.petRepository.findById(id);
    }

    @Override
    public Iterable<Pet> findOneByStatus(String status) {
        return this.petRepository.findOneByStatus(status);
    }

    @Override
    public Pet save(Pet pet) {
        return this.petRepository.save(pet);
    }

    @Override
    public void delete(Integer id) {
        petRepository.deleteById(id);
    }
}