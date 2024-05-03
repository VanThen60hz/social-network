package com.dtu.socialnetwork.service.impl;

import com.dtu.socialnetwork.models.User;
import com.dtu.socialnetwork.repository.UserRepository;
import com.dtu.socialnetwork.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        User newUser = new User();

        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());

        return userRepository.save(newUser);
    }

    @Override
    public User findUserById(Integer userId) throws Exception {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            return user.get();
        }

        throw new Exception("User not exist with id = " + userId);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User followUser(Integer userId1, Integer userId2) throws Exception {

        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            throw new Exception("User not exist with id = " + userId1 + " or " + userId2);
        }

        user1.getFollowings().add(user2.getId());
        user2.getFollowers().add(user1.getId());

        userRepository.save(user1);
        userRepository.save(user2);

        return user1;
    }

    @Override
    public User updateUser(User user, Integer userId) throws Exception {
        Optional<User> userFind = userRepository.findById(userId);

        if (userFind.isEmpty()) {
            throw new Exception("User not exist with id = " + userId);
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

    @Override
    public List<User> searchUser(String query) {
        return userRepository.searchUser(query);
    }
}
