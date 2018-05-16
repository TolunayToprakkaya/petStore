package com.example.petstore.controllers;

import com.example.petstore.models.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.petstore.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@Api(value="UserControllerAPI", produces=MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    //Find All
    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll(){
        return userService.findAll();
    }

    //View
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation("Gets the user with specfic id")
    @ApiResponses(value={@ApiResponse(code = 200, message = "OK", response = User.class)})
    public void view(@PathVariable String id){
        userService.findOneById(id);
    }

    //Save
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody User user){
        userService.save(user);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody User user){
        userService.update(user);
    }

    //Patch
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public void patch(@RequestBody User user){
        userService.update(user);
    }

    //Delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        userService.delete(id);
    }

}
