package com.example.petstore.repositories;

import com.example.petstore.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "categories", collectionResourceRel = "categories", exported = false)
public interface CategoryRepository extends JpaRepository<Category, String> {
}
