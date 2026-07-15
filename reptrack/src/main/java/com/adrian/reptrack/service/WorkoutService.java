package com.adrian.reptrack.service;

import org.springframework.stereotype.Service;
import com.adrian.reptrack.entity.Workout;
import com.adrian.reptrack.repository.WorkoutRepository;

@Service
public class WorkoutService {
    
    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository){
        this.workoutRepository = workoutRepository;
    }

    public void createWorkout(Workout workout){
        if(workout.getWorkoutTitle() == null || workout.getWorkoutTitle().isBlank()){
            throw new IllegalStateException("Workout title is required!");
        }
        else if(workout.getWorkoutTitle().length() > 30){
            throw new IllegalStateException("Workout title is too long!");
        }
        workoutRepository.save(workout);
    }

}
