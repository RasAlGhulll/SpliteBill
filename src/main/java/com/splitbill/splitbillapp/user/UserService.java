package com.splitbill.splitbillapp.user;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private List<User> users = Arrays.asList(
            new User("942","shreyans","123"),
                new User("912","shrey","234")
        );

    public List<User> getAllUsers(){
        return users;
    }
}
