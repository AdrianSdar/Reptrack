package com.adrian.reptrack.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adrian.reptrack.dto.ExerciseRequest;
import com.adrian.reptrack.dto.ExerciseResponse;
import com.adrian.reptrack.dto.ExerciseUpdateRequest;
import com.adrian.reptrack.entity.Exercise;
import com.adrian.reptrack.entity.Workout;
import com.adrian.reptrack.repository.ExerciseRepository;
import com.adrian.reptrack.repository.WorkoutRepository;

@Service
public class ExerciseService {
    
    private final ExerciseRepository exerciseRepository;
    private final WorkoutRepository workoutRepository;

    public ExerciseService(ExerciseRepository exerciseRepository, WorkoutRepository workoutRepository){
        this.exerciseRepository = exerciseRepository;
        this.workoutRepository = workoutRepository;
    }

    public void createExercise(ExerciseRequest exerciseRequest){
        if(exerciseRequest.exerciseName() == null || exerciseRequest.exerciseName().isBlank()){
            throw new IllegalStateException("Exercise name is required!");
        }
        else if(exerciseRequest.exerciseName().trim().length() > 30){
            throw new IllegalStateException("Exercise name is too long!");
        }
        else if(exerciseRequest.reps() <= 0|| exerciseRequest.sets() <= 0){
            throw new IllegalStateException("Sets and reps must be at least 1!"); 
        }
        Workout workout = workoutRepository.findById(exerciseRequest.workoutId()).orElseThrow(() -> new IllegalStateException("Workout not found!"));

        Exercise exercise = new Exercise();
        exercise.setReps(exerciseRequest.reps());
        exercise.setSets(exerciseRequest.sets());
        exercise.setWeight(exerciseRequest.weight());
        exercise.setExerciseName(exerciseRequest.exerciseName());
        exercise.setWorkout(workout);
        exerciseRepository.save(exercise);
    }

    public List<ExerciseResponse> getAllExercises(){
        return exerciseRepository.findAll().stream().map(exercise -> new ExerciseResponse(exercise.getExerciseName(), exercise.getSets(), exercise.getReps(), exercise.getWeight(), exercise.getId(), exercise.getWorkout().getId())).toList();
    }

    public ExerciseResponse getExerciseById(Long id){
        Exercise exercise = exerciseRepository.findById(id).orElseThrow(() -> new IllegalStateException("Exercise not found!"));
        return new ExerciseResponse(exercise.getExerciseName(), exercise.getSets(), exercise.getReps(), exercise.getWeight(), exercise.getId(), exercise.getWorkout().getId());
    }

    public void deleteExerciseById(Long id){
        exerciseRepository.deleteById(id);
    }

    public ExerciseUpdateRequest updateExerciseById(Long id, ExerciseUpdateRequest exerciseUpdateRequest){
        Exercise exisitingExercise = exerciseRepository.findById(id).orElseThrow(() -> new IllegalStateException("Exercise not found!"));
        exisitingExercise.setExerciseName(exerciseUpdateRequest.exerciseName());
        exisitingExercise.setReps(exerciseUpdateRequest.reps());
        exisitingExercise.setSets(exerciseUpdateRequest.sets());
        exisitingExercise.setWeight(exerciseUpdateRequest.weight());
        exerciseRepository.save(exisitingExercise);
        return new ExerciseUpdateRequest(exisitingExercise.getExerciseName(), exisitingExercise.getSets(), exisitingExercise.getReps(), exisitingExercise.getWeight());
    }
}
