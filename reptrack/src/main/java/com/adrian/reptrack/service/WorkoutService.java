package com.adrian.reptrack.service;

import java.util.List;
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
        else if(workout.getWorkoutTitle().trim().length() > 30){
            throw new IllegalStateException("Workout title is too long!");
        }
        workoutRepository.save(workout);
    }

    public List<Workout> getAllWorkouts(){
        return workoutRepository.findAll();
    }

    public Workout getWorkoutById(Long id){
        return workoutRepository.findById(id).orElseThrow(() -> new IllegalStateException("Workout not found!"));
    }

    public void deleteWorkoutById(Long id){
        workoutRepository.deleteById(id);
    }

    public Workout updateWorkoutById(Long id, Workout updatedWorkout){
        Workout exisitingWorkout = workoutRepository.findById(id).orElseThrow(() -> new IllegalStateException("Workout not found!"));
        exisitingWorkout.setWorkoutTitle(updatedWorkout.getWorkoutTitle());
        exisitingWorkout.setDate(updatedWorkout.getDate());
        workoutRepository.save(exisitingWorkout);
        return exisitingWorkout;
    }

}
