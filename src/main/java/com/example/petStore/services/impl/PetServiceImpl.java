package com.example.petStore.services.impl;

import com.example.petStore.models.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.petStore.repositories.PetRepository;
import com.example.petStore.services.PetService;

import java.util.List;
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
    public Optional<Pet> findOneById(String id) {
        return this.petRepository.findById(id);
    }

    @Override
    public Pet save(Pet pet) {
        return this.petRepository.save(pet);
    }

    @Override
    public void delete(String id) {
        petRepository.deleteById(id);
    }
}
