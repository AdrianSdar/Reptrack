package com.adrian.reptrack.service;

import org.springframework.stereotype.Service;
import com.adrian.reptrack.entity.User;
import com.adrian.reptrack.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    public void registerUser(User user){
        if(user.getEmail() == null || user.getEmail().isBlank()){
            throw new IllegalStateException("Email is required!");
        }
        else if(user.getUsername() == null || user.getUsername().isBlank()){
            throw new IllegalStateException("Username is required!");
        }
        else if(user.getPassword() == null || user.getPassword().isBlank()){
            throw new IllegalStateException("Password is required!");
        }
        else if(userRepository.existsByEmail(user.getEmail())){
            throw new IllegalStateException("Email has already been used!");
        }
        else{
            userRepository.save(user);
        }
    }
}
