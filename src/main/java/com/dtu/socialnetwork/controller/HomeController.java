package com.dtu.socialnetwork.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String homeControllerHandler() {
        return "Hello Home Controller!";
    }

    @GetMapping("/home")
    public String homeControllerHandler2() {
        return "Hello I'm Testing Home Controller!";
    }
}
