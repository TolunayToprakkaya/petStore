package services.impl;

import models.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import repositories.UserRepository;
import services.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    private  UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User save(@Valid @RequestBody User user){
        return userRepository.save(user);
    }

    public Optional<User> findOneById(@PathVariable(value = "id") Integer id){
        return userRepository.findById(id);
    }

}
