package com.arberzeneli.userapi.controllers;

import com.arberzeneli.userapi.model.User;
import com.arberzeneli.userapi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    Logger logger= LoggerFactory.getLogger(UserController.class);
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    public UserController() {}

    @GetMapping(path = "api/v1/users")
    public List<User> getUsers(){

        logger.info("getUsers method called!");
        logger.error("Error message in getUser method");
        //logger.trace("getUsers method called!");

        return userService.getUsers();
    }
    @GetMapping("/api/v1/user/{uid}")
    public User getUser (@PathVariable("uid") Long userId) {
        logger.info("getUser is called");
        return userService.getUserByID(userId);
    }

    @PostMapping(path="/api/v1/user")
    public User addUser(@RequestBody User user) {
        logger.info("addUser method is called");
        return userService.addUser(user);
    }

    @PutMapping(path="/api/v1/user")
    public User updateUser(@RequestBody User user) {
        logger.info("updateUser method is called");
        return userService.updateUser(user);
    }

    @DeleteMapping(path="/api/v1/user")
    public User deleteUser(@RequestBody User user){
        logger.info("getUser is called");
        return userService.deleteUser(user);
    }

}
