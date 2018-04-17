package com.example.petstore.services;

import com.example.petstore.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();
    Optional<User> findOneById(String id);
    User save(User user);
    User update(User user);
    void delete(String id);

}
