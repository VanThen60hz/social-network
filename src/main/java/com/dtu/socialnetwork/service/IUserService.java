package com.dtu.socialnetwork.service;

import com.dtu.socialnetwork.dto.user.UserDto;
import com.dtu.socialnetwork.exception.UserException;
import com.dtu.socialnetwork.models.User;

import java.util.List;

public interface IUserService {
    List<UserDto> findAllUser();

    UserDto registerUser(User user);

    UserDto findUserById(Integer userId) throws UserException;

    UserDto findUserByEmail(String email);

    UserDto followUser(Integer userId1, Integer userId2) throws UserException;

    UserDto updateUser(User user, Integer userId) throws UserException;

    List<UserDto> searchUser(String query);

    User findByJwt(String jwt);
}
