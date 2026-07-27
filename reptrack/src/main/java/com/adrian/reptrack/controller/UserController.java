package com.adrian.reptrack.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.reptrack.dto.LoginRequest;
import com.adrian.reptrack.dto.LoginResponse;
import com.adrian.reptrack.dto.RegisterRequest;
import com.adrian.reptrack.dto.UserResponse;
import com.adrian.reptrack.dto.UserUpdateRequest;
import com.adrian.reptrack.service.UserService;

@RestController
@RequestMapping ("/users")
public class UserController {
    private final UserService userService;

    public UserController (UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public String register(@RequestBody RegisterRequest registerRequest){
        userService.registerUser(registerRequest);
        return "User registered";
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return userService.login(loginRequest);
    }

    @GetMapping
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    public UserUpdateRequest updateUserById(@PathVariable Long id, @RequestBody UserUpdateRequest userUpdateRequest){
        return userService.updateUserById(id, userUpdateRequest);
    }
    
}
