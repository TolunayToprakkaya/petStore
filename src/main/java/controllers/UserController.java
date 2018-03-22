package controllers;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import repositories.UserRepository;
import services.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;



    /*
    @Autowired
    private UserRepository userRepository;

    //Find All Users
    @GetMapping("/all")
    public List<User> findAll(){
        return userRepository.findAll();
    }

    //Save a new User
    @GetMapping("/save")
    public User saveUser(@Valid @RequestBody User user){
        return userRepository.save(user);
    }

    //Find One User
    @GetMapping("/{id}")
    public Optional<User> findUserById(@PathVariable(value = "id") Integer id){
        return userRepository.findById(id);
    }
    */
}
