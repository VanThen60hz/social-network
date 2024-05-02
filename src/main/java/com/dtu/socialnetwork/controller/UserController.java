package com.dtu.socialnetwork.controller;

import com.dtu.socialnetwork.models.User;
import com.dtu.socialnetwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;


    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId") Integer id) throws Exception {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        }

        throw new Exception("User not exist with id = " + id);

    }

    @PostMapping("/users")
    public User CreateUser(@RequestBody User user) {
        User newUser = new User();

        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());

        return userRepository.save(newUser);
    }

    @PatchMapping("/users/{userId}")
    public User updateUser(@PathVariable("userId") Integer id, @RequestBody User user) throws Exception {

        Optional<User> userFind = userRepository.findById(id);

        if (userFind.isEmpty()) {
            throw new Exception("User not exist with id = " + id);
        }

        User oldUser = userFind.get();

        if (user.getFirstName() != null) {
            oldUser.setFirstName(user.getFirstName());
        }

        if (user.getLastName() != null) {
            oldUser.setLastName(user.getLastName());
        }

        if (user.getEmail() != null) {
            oldUser.setEmail(user.getEmail());
        }

        if (user.getPassword() != null) {
            oldUser.setPassword(user.getPassword());
        }

        return userRepository.save(oldUser);

    }


    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable("userId") Integer id) throws Exception {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new Exception("User not exist with id = " + id);
        }

        userRepository.deleteById(id);

        return "User delete successfully with id = " + id;
    }
}
