package com.example.petStore.repositories;

import com.example.petStore.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "tag", collectionResourceRel = "tag")
public interface TagRepository extends JpaRepository<Tag, Integer>{
}
