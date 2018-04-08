package com.example.petStore.services;

import com.example.petStore.models.User;

import java.util.Optional;

public interface UserService {

    Iterable<User> findAll();
    Optional<User> findOneById(String id);
    User save(User user);
    User update(User user);
    void delete(String id);

}
