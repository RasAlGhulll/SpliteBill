package com.splitbill.splitbillapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/users/{id}")
    public User getUser(@PathVariable String id){
        return userService.getUser(id);
    }

    @PostMapping(value = "/users")
    public void addUser(@RequestBody User newUser){
        userService.addUser(newUser);
    }

    @PutMapping(value = "/users/{id}")
    public void updateUser(@RequestBody User updatedUser,@PathVariable String id){
        userService.updateUser(updatedUser,id);
    }

    @DeleteMapping(value = "/users/{id}")
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }
}
