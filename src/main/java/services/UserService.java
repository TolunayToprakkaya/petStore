package services;

import models.User;
import models.seedwork.AbstractEntity;

public interface UserService {

    Iterable<User> findAll();
    AbstractEntity findOneUsername(Integer id);
    User save(User user);
    void delete(Integer id);

}
