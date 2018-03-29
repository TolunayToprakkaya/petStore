package services;

import models.User;

import java.util.Optional;

public interface UserService {

    Iterable<User> findAll();
    Optional<User> findOneById(Integer id);
    User save(User user);
    void delete(Integer id);

}
