package services.impl;

import models.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import repositories.PetRepository;

import java.util.List;
import java.util.Optional;

@Service("petService")
public class PetServiceImpl {

    @Autowired
    private PetRepository petRepository;

    public List<Pet> findAll(){
        return petRepository.findAll();
    }

    public Pet save(Pet pet){
        return petRepository.save(pet);
    }

    public Optional<Pet> findOneByPet(@PathVariable(value = "id") Integer id){
        return petRepository.findById(id);
    }

    public void delete(@PathVariable(value = "id") Integer id){
        petRepository.deleteById(id);
    }
}
