package com.splitbill.splitbillapp.user;

import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>(Arrays.asList(
            new User("942","shreyans","123"),
                new User("912","shrey","234")
        ));

    public List<User> getAllUsers(){
        return users;
    }

    public User getUser(String id){
        return users.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addUser(User newUser){
        users.add(newUser);
    }

    public void updateUser(User updatedUser,String id){
        for(int i=0; i<users.size(); i++){
            User temp = users.get(i);
            if(temp.getId().equals(id)){
                users.set(i,updatedUser);
                return;
            }
        }
    }

    public void deleteUser(String id){
        users.removeIf(t -> t.getId().equals(id));
    }
}
