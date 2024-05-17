package com.dtu.socialnetwork.service;

import com.dtu.socialnetwork.dto.user.UserDto;
import com.dtu.socialnetwork.models.User;

import java.util.List;

public interface IUserService {
    List<UserDto> findAllUser();

    UserDto registerUser(User user);

    UserDto findUserById(Integer userId) throws Exception;

    UserDto findUserByEmail(String email);

    UserDto followUser(Integer userId1, Integer userId2) throws Exception;

    UserDto updateUser(User user, Integer userId) throws Exception;

    List<UserDto> searchUser(String query);

    User findByJwt(String jwt);
}
