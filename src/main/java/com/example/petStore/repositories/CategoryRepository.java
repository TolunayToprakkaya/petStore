package com.example.petStore.repositories;

import com.example.petStore.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "category", collectionResourceRel = "category")
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
