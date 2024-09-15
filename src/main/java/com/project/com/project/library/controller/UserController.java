package com.project.com.project.library.controller;


import com.project.com.project.library.Service.UserService;
import com.project.com.project.library.entity.User;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<User> GetAllUsers(){
        return userService.findAll();
    }
    public User AddUser(@RequestBody User user){
        return userService.save(user);
    }


}
