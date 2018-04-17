package com.example.petstore.repositories;

import com.example.petstore.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "pets", collectionResourceRel = "pets", exported = false)
public interface PetRepository extends JpaRepository<Pet, String> {
}
