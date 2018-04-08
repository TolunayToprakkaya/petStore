package com.example.petstore.repositories;

import com.example.petstore.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "pet", collectionResourceRel = "pet")
public interface PetRepository extends JpaRepository<Pet, Integer> {

    Iterable<Pet> findOneByStatus(@Param("status") String status);

}
