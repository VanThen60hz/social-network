package com.dtu.socialnetwork.service.impl;

import com.dtu.socialnetwork.config.JwtProvider;
import com.dtu.socialnetwork.dto.user.UserDto;
import com.dtu.socialnetwork.mapper.UserMapper;
import com.dtu.socialnetwork.models.User;
import com.dtu.socialnetwork.repository.UserRepository;
import com.dtu.socialnetwork.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserDto> findAllUser() {
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto registerUser(User user) {
        User newUser = new User();

        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());

        return userMapper.toDto(userRepository.save(newUser));
    }

    @Override
    public UserDto findUserById(Integer userId) throws Exception {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            return userMapper.toDto(user.get());
        }

        throw new Exception("User not exist with id = " + userId);
    }

    @Override
    public UserDto findUserByEmail(String email) {
        return userMapper.toDto(userRepository.findByEmail(email));
    }

    @Override
    public UserDto followUser(Integer reqUserId, Integer userId2) throws Exception {

        User reqUser = userRepository.findById(reqUserId).orElse(null);
        User user2 = userRepository.findById(userId2).orElse(null);

        if (reqUser == null || user2 == null) {
            throw new Exception("User not exist with id = " + reqUserId + " or " + userId2);
        }

        reqUser.getFollowings().add(user2.getId());
        user2.getFollowers().add(reqUser.getId());

        userRepository.save(reqUser);
        userRepository.save(user2);

        return userMapper.toDto(reqUser);
    }

    @Override
    public UserDto updateUser(User user, Integer userId) throws Exception {
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

        if (user.getGender() != null) {
            oldUser.setGender(user.getGender());
        }

        User saveUser = userRepository.save(oldUser);
        saveUser.setPassword(null);
        return userMapper.toDto(saveUser);
    }

    @Override
    public List<UserDto> searchUser(String query) {
        return userRepository.searchUser(query).stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public User findByJwt(String jwt) {
        String email = JwtProvider.getEmailFromToken(jwt);


        return userRepository.findByEmail(email);
    }
}
