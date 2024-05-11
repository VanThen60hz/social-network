package com.dtu.socialnetwork.controller;

import com.dtu.socialnetwork.dto.user.UserDto;
import com.dtu.socialnetwork.models.User;
import com.dtu.socialnetwork.repository.UserRepository;
import com.dtu.socialnetwork.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping()
    public List<UserDto> getUsers() {
        return userService.findAllUser();
    }

    @GetMapping("{userId}")
    public UserDto getUserById(@PathVariable("userId") Integer id) throws Exception {
        return userService.findUserById(id);
    }

    @PostMapping()
    public UserDto CreateUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PatchMapping("{userId}")
    public UserDto updateUser(@PathVariable("userId") Integer id, @RequestBody User user) throws Exception {
        return userService.updateUser(user, id);
    }


    @DeleteMapping("{userId}")
    public String deleteUser(@PathVariable("userId") Integer id) throws Exception {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new Exception("User not exist with id = " + id);
        }

        userRepository.deleteById(id);

        return "User delete successfully with id = " + id;
    }

    @PutMapping("{userId1}/follow/{userId2}")
    public UserDto followUser(@PathVariable("userId1") Integer userId1, @PathVariable("userId2") Integer userId2) throws Exception {
        return userService.followUser(userId1, userId2);
    }

    @GetMapping("search")
    public List<UserDto> searchUser(@RequestParam("query") String query) {
        return userService.searchUser(query);
    }
}
