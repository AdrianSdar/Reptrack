package com.adrian.reptrack.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.adrian.reptrack.dto.LoginRequest;
import com.adrian.reptrack.dto.LoginResponse;
import com.adrian.reptrack.dto.RegisterRequest;
import com.adrian.reptrack.dto.UserResponse;
import com.adrian.reptrack.dto.UserUpdateRequest;
import com.adrian.reptrack.entity.User;
import com.adrian.reptrack.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private JwtService jwtService;

    public UserService(UserRepository userRepository, JwtService jwtService){
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }
    
    public void registerUser(RegisterRequest registerRequest){
        if(registerRequest.email() == null || registerRequest.email().isBlank()){
            throw new IllegalStateException("Email is required!");
        }
        else if(registerRequest.name() == null || registerRequest.name().isBlank()){
            throw new IllegalStateException("Name is required!");
        }
        else if(registerRequest.name().trim().length() > 20){
            throw new IllegalStateException("Name is too long!");
        }
        else if(registerRequest.password() == null || registerRequest.password().isBlank()){
            throw new IllegalStateException("Password is required!");
        }
        else if(userRepository.existsByEmailIgnoreCase(registerRequest.email())){
            throw new IllegalStateException("Email has already been used!");
        }
        else{
            String hashedPassword = passwordEncoder.encode(registerRequest.password());
            User user = new User();
            user.setName(registerRequest.name());
            user.setEmail(registerRequest.email());
            user.setPassword(hashedPassword);
            userRepository.save(user);
        }
    }

    public LoginResponse login(LoginRequest loginRequest){
        User existingUser = userRepository.findByEmailIgnoreCase(loginRequest.email()).orElseThrow(() -> new IllegalStateException("Invalid email or password!"));
        if(!passwordEncoder.matches(loginRequest.password(), existingUser.getPassword())){
            throw new IllegalStateException("Invalid email or password!");
        }
        String token = jwtService.generateToken(existingUser);
        return new LoginResponse(token);
    }

    public List<UserResponse> getAllUsers(){
        return userRepository.findAll().stream().map(user -> new UserResponse(user.getId(), user.getName(), user.getEmail())).toList();
    }

    public UserResponse getUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User not found!"));
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    public UserUpdateRequest updateUserById(Long id, UserUpdateRequest userUpdateRequest){
        User existingUser = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User not found!"));
        existingUser.setName(userUpdateRequest.name());
        existingUser.setEmail(userUpdateRequest.email());
        String hashedPassword = passwordEncoder.encode(userUpdateRequest.password());
        existingUser.setPassword(hashedPassword);
        userRepository.save(existingUser);
        return new UserUpdateRequest(existingUser.getName(), existingUser.getEmail(), existingUser.getPassword());
    }
}
