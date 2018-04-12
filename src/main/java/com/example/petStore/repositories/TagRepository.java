package com.example.petStore.repositories;

import com.example.petStore.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "tags", collectionResourceRel = "tags", exported = false)
public interface TagRepository extends JpaRepository<Tag, String>{
}
