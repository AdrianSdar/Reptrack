package com.adrian.reptrack.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
    @JsonProperty(access = Access.WRITE_ONLY)
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
        return username;
    }
     public String getEmail(){
        return email;
    }
    
    public String getPassword(){
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
