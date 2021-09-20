package com.arberzeneli.userapi.controllers;

import com.arberzeneli.userapi.model.User;
import com.arberzeneli.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping(path = "api/v1/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/api/v1/user/{uid}")
    public User getUser (@PathVariable("uid") Long userId) {
       return userService.getUserByID(userId);
    }

    @PostMapping(path="/api/v1/user")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping(path="/api/v1/user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping(path="/api/v1/user")
    public User deleteUser(@RequestBody User user){
        return userService.deleteUser(user);
    }

}
