package com.adrian.reptrack.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;

    public User(){}

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    } 

    public Long getId(){
        return id;
    }

    public String getUsername(){
        if(username.isEmpty()){
            throw new IllegalStateException("Username is empty");
        }
        return username;
    }
     public String getEmail(){
        if(email.isEmpty()){
            throw new IllegalStateException("E-mail is empty");
        }
        else if (!email.contains("@")){
            throw new IllegalStateException("E-mail is not valid");
        }
        return email;
    }
     public String getPassword(){
        if(password.isEmpty()){
            throw new IllegalStateException("Password is empty");
        }
        return password;
    }

    public void setId(Long newId){
        this.id = newId;
    }
    public void setUsername(String newUsername){
        this.username = newUsername;
    }
    public void setEmail(String newEmail){
        this.email = newEmail;
    }
    public void setPassword(String newPassword){
        this.password = newPassword;
    }
}
