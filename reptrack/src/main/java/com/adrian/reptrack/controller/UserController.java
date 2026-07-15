package com.adrian.reptrack.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.adrian.reptrack.entity.User;
import com.adrian.reptrack.service.UserService;

@RestController
@RequestMapping ("/users")
public class UserController {
    private final UserService userService;

    public UserController (UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user){
        userService.registerUser(user);
        return "User registered";
    }
    
}
