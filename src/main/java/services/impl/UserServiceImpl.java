package services.impl;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;
import services.UserService;

import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    /*
    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> findOne(Integer id) {
        return this.userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        this.userRepository.deleteById(id);
    }
    */


    /*
    @Autowired
    private UserService userService;

    @Override
    public Iterable<User> findAll() {
        return this.userService.findAll();
    }

    @Override
    public User findOne(Integer id){
        return this.userService.findOne(id);
    }

    @Override
    public User save(User user) {
        return this.userService.save(user);
    }

    @Override
    public void delete(Integer id) {
        this.userService.delete(id);
    }
    */
}
