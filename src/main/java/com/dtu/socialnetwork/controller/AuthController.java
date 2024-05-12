package com.dtu.socialnetwork.controller;

import com.dtu.socialnetwork.config.JwtProvider;
import com.dtu.socialnetwork.mapper.UserMapper;
import com.dtu.socialnetwork.models.User;
import com.dtu.socialnetwork.repository.UserRepository;
import com.dtu.socialnetwork.request.LoginRequest;
import com.dtu.socialnetwork.response.AuthResponse;
import com.dtu.socialnetwork.service.CustomerUserDetailService;
import com.dtu.socialnetwork.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerUserDetailService customerUserDetailService;

    @PostMapping("/signup")
    public AuthResponse CreateUser(@RequestBody User user) {
        User isExist = userRepository.findByEmail(user.getEmail());

        if (isExist != null) {
            throw new RuntimeException("User already exist with email = " + user.getEmail());
        }

        User newUser = new User();

        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(newUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(), savedUser.getPassword());

        String token = JwtProvider.generateToken(authentication);

        return new AuthResponse(token, "Register successfully ...");
    }

    @PostMapping("/signin")
    public AuthResponse SignIn(@RequestBody LoginRequest LoginRequest) {
        Authentication authentication = authenticate(LoginRequest.getEmail(), LoginRequest.getPassword());

        String token = JwtProvider.generateToken(authentication);

        return new AuthResponse(token, "Login successfully ...");
    }

    private Authentication authenticate(String username, String password) {
        UserDetails userDetails = customerUserDetailService.loadUserByUsername(username);

        if (userDetails == null) {
            throw new BadCredentialsException("Invalid username ...");
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid password ...");
        }
        return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
    }
}
