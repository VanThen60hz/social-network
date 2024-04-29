package com.dtu.socialnetwork.controller;

import com.dtu.socialnetwork.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        users.add(new User("Thang", "Nguyen Van", "helloword@gmail.com", "password"));
        users.add(new User("Then", "Van", "helloworld@gmail.com", "password"));

        return users;
    }
}
