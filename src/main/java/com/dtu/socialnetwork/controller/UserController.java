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
@RequestMapping("/api/user")
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


    @PatchMapping()
    public UserDto updateUser(@RequestHeader("Authorization") String jwt, @RequestBody User user) throws Exception {

        Integer id = userService.findByJwt(jwt).getId();


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

    @PutMapping("follow/{userId2}")
    public UserDto followUser(@RequestHeader("Authorization") String jwt, @PathVariable("userId2") Integer userId2) throws Exception {
        Integer reqUserId = userService.findByJwt(jwt).getId();

        return userService.followUser(reqUserId, userId2);
    }

    @GetMapping("search")
    public List<UserDto> searchUser(@RequestParam("query") String query) {
        return userService.searchUser(query);
    }

    @GetMapping("profile")
    public User getUserFromToken(@RequestHeader("Authorization") String jwt) {


        User user = userService.findByJwt(jwt);
        user.setPassword(null);

        return user;
    }
}
