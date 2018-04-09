package com.example.petStore.services.impl;

import com.example.petStore.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.petStore.repositories.UserRepository;
import com.example.petStore.services.UserService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> findOneById(String id) {
        return this.userRepository.findOneById(id);
    }

    @Transactional
    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Transactional
    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public void delete(String id) {
        this.userRepository.delete(id);
    }
}
