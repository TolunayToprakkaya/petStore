package com.example.petstore.services;

import com.example.petstore.models.User;

import java.util.Optional;

public interface UserService {

    Iterable<User> findAll();
    Optional<User> findOneById(String id);
    User save(User user);
    void delete(String id);
    User update(User user);
}
