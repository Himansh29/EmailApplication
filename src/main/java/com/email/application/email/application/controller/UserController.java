package com.email.application.email.application.controller;

import com.email.application.email.application.entity.User;
import com.email.application.email.application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users/")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    @PostMapping("/users/")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

}

