package com.example.petstore.repositories;

import com.example.petstore.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "users", collectionResourceRel = "users", exported = false)
public interface UserRepository extends JpaRepository<User, String> {
}
