package com.example.petStore.repositories;

import com.example.petStore.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;


@RepositoryRestResource(path = "users", collectionResourceRel = "users", exported = false)
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findOneById(String id);
    void delete(String id);

}
