package com.adrian.reptrack.service;

import org.springframework.stereotype.Service;
import com.adrian.reptrack.entity.Exercise;
import com.adrian.reptrack.repository.ExerciseRepository;

@Service
public class ExerciseService {
    
    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository){
        this.exerciseRepository = exerciseRepository;
    }

    public void createExercise(Exercise exercise){
        if(exercise.getWorkout() == null){
            throw new IllegalStateException("A workout needs to be created first!");
        }
        else if(exercise.getExerciseName() == null || exercise.getExerciseName().isBlank()){
            throw new IllegalStateException("Exercise name is required!");
        }
        else if(exercise.getExerciseName().trim().length() > 30){
            throw new IllegalStateException("Exercise name is too long!");
        }
        else if(exercise.getReps() <= 0|| exercise.getSets() <= 0){
            throw new IllegalStateException("Sets and reps must be at least 1!"); 
        }
        exerciseRepository.save(exercise);
    }
}
