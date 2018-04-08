package com.example.petstore.repositories;

import com.example.petstore.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "category", collectionResourceRel = "category")
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
