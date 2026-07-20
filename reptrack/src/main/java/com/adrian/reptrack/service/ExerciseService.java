package com.adrian.reptrack.service;

import java.util.List;

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

    public List<Exercise> getAllExercises(){
        return exerciseRepository.findAll();
    }

    public Exercise getExerciseById(Long id){
        return exerciseRepository.findById(id).orElseThrow(() -> new IllegalStateException("Exercise not found!"));
    }

    public void deleteExerciseById(Long id){
        exerciseRepository.deleteById(id);
    }

    public Exercise updateExerciseById(Long id, Exercise updatedExercise){
        Exercise exisitingExercise = exerciseRepository.findById(id).orElseThrow(() -> new IllegalStateException("Exercise not found!"));
        exisitingExercise.setExerciseName(updatedExercise.getExerciseName());
        exisitingExercise.setReps(updatedExercise.getReps());
        exisitingExercise.setSets(updatedExercise.getSets());
        exisitingExercise.setWeight(updatedExercise.getWeight());
        exerciseRepository.save(exisitingExercise);
        return exisitingExercise;
    }
}
