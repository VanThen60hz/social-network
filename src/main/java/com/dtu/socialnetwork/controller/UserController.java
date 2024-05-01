package com.dtu.socialnetwork.controller;

import com.dtu.socialnetwork.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Thang", "Nguyen Van", "helloword@gmail.com", "password"));
        users.add(new User(2, "Then", "Van", "helloworld@gmail.com", "password"));
    }


    @GetMapping("/users")
    public List<User> getUsers() {

        return users;
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId") Integer id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/users")
    public User CreateUser(@RequestBody User user) {
        users.add(user);
        return user;
    }

    @PatchMapping("/users/{userId}")
    public User updateUser(@PathVariable("userId") Integer id, @RequestBody User user) {
        User userUpdate = users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (userUpdate != null) {
            userUpdate.setFirstName(user.getFirstName());
            userUpdate.setLastName(user.getLastName());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setPassword(user.getPassword());
        }


        return userUpdate;
    }


    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable("userId") Integer id) {
        User userDelete = users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (userDelete != null) {
            users.remove(userDelete);
            return "Delete success!";
        }
        return "Can't find user to delete!";
    }
}
