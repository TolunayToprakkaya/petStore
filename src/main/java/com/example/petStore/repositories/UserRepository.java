package com.example.petStore.repositories;

import com.example.petStore.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource(path = "users", collectionResourceRel = "users", exported = false)
public interface UserRepository extends JpaRepository<User, String> {
}
