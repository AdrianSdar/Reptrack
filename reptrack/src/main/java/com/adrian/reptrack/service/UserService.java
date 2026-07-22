package com.adrian.reptrack.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.adrian.reptrack.entity.User;
import com.adrian.reptrack.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    public void registerUser(User user){
        System.out.println(user.getPassword());
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
            String hashedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashedPassword);
            userRepository.save(user);
        }
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User not found!"));
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    public User updateUserById(Long id, User updatedUser){
        User existingUser = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User not found!"));
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        userRepository.save(existingUser);
        return existingUser;
    }
}
