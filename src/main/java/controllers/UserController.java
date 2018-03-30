package controllers;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    //Find All
    @RequestMapping(value = "")
    public void findAll(){
        userService.findAll();
    }

    //View
    @RequestMapping(value = "/view/{id}")
    public void view(@PathVariable Integer id){
        userService.findOneById(id);
    }

    //Edit
    @RequestMapping(value = "/edit/{id}")
    public void edit(@PathVariable Integer id){
        userService.findOneById(id);
    }

    //Save
    @RequestMapping(value = "/save")
    public void save(User user){
        userService.save(user);
    }
    /*
    //Delete
    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable Integer id){
        userService.delete(id);
    }
    */
}
