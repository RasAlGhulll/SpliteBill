package com.splitbill.splitbillapp.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @GetMapping(value = "/users")
    public List<User> getAllUsers(){
        return Arrays.asList(
                new User("942","shreyans","123"),
                new User("912","shrey","234")
        );
    }
}
