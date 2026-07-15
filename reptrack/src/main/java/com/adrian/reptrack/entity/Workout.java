package com.adrian.reptrack.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String workoutTitle;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Workout(){}

    public Workout(String workoutTitle, LocalDate date, User user){
        this.workoutTitle = workoutTitle;
        this.date = date;
        this.user = user;
    }

    public Long getId(){
        return id;
    }

    public String getWorkoutTitle(){
        return workoutTitle;
    }

    public LocalDate getDate(){
        return date;
    }

    public User getUser(){
        return user;
    }

    public void setId(Long newId){
        this.id = newId;
    }

    public void setWorkoutTitle(String newWorkoutTitle){
        this.workoutTitle = newWorkoutTitle;
    }

    public void setDate(LocalDate newDate){
        this.date = newDate;
    }

    public void setUser(User newUser){
        this.user = newUser;
    }    
}
