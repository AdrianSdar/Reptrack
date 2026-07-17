package com.adrian.reptrack.service;

import org.springframework.stereotype.Service;
import com.adrian.reptrack.entity.Exercise;
import com.adrian.reptrack.repository.ExerciseRepository;

@Service
public class ExerciseService {
    
    private ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository){
        this.exerciseRepository = exerciseRepository;
    }

    public void createExercise(Exercise exercise){
        if(exercise.getexerciseName() == null || exercise.getexerciseName().isBlank()){
            throw new IllegalStateException("Exercise name is required!");
        }
        else if(exercise.getexerciseName().trim().length() > 30){
            throw new IllegalStateException("Exercise name is too long!");
        }
        else if(exercise.getReps() < 0|| exercise.getSets() < 0){
            throw new IllegalStateException("Reps/Sets can not be lower than 0!"); 
        }
        exerciseRepository.save(exercise);
    }
}
