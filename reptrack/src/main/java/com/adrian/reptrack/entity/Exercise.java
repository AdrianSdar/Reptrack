package com.adrian.reptrack.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String exerciseName;
    private int sets;
    private int reps;
    private double weight;
    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    public Exercise(){}

    public Exercise(String exerciseName, int sets, int reps, double weight, Workout workout){
        this.exerciseName = exerciseName;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.workout = workout;
    }

    public Long getId(){
        return id;
    }

    public String getexerciseName(){
        return exerciseName;
    }

    public int getSets(){
        return sets;
    }

    public int getReps(){
        return reps;
    }

    public double weight(){
        return weight;
    }

    public Workout getWorkout(){
        return workout;
    }

    public void setId(Long newId){
        this.id = newId;
    }
    
    public void setExerciseName(String newExerciseName){
        this.exerciseName = newExerciseName;
    }

    public void setSets(int newSets){
        this.sets = newSets;
    }

    public void setReps(int newReps){
        this.reps = newReps;
    }

    public void setWeight(double newWeight){
        this.weight = newWeight;
    }

    public void setWorkout(Workout newWorkout){
        this.workout = newWorkout;
    }

}
