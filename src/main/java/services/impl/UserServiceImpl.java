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
