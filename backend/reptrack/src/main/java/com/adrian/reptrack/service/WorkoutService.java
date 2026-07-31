package com.adrian.reptrack.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.adrian.reptrack.dto.WorkoutRequest;
import com.adrian.reptrack.dto.WorkoutResponse;
import com.adrian.reptrack.dto.WorkoutUpdateRequest;
import com.adrian.reptrack.entity.User;
import com.adrian.reptrack.entity.Workout;
import com.adrian.reptrack.repository.UserRepository;
import com.adrian.reptrack.repository.WorkoutRepository;

@Service
public class WorkoutService {
    
    private final WorkoutRepository workoutRepository;
    private final UserRepository userRepository;

    public WorkoutService(WorkoutRepository workoutRepository, UserRepository userRepository){
        this.workoutRepository = workoutRepository;
        this.userRepository = userRepository;
    }

    public void createWorkout(WorkoutRequest workoutRequest){
        if(workoutRequest.workoutTitle() == null || workoutRequest.workoutTitle().isBlank()){
            throw new IllegalStateException("Workout title is required!");
        }
        else if(workoutRequest.workoutTitle().trim().length() > 30){
            throw new IllegalStateException("Workout title is too long!");
        }
        User user = userRepository.findById(workoutRequest.userId()).orElseThrow(() -> new IllegalStateException("User not found!"));

        Workout workout = new Workout();
        workout.setWorkoutTitle(workoutRequest.workoutTitle());
        workout.setDate(workoutRequest.date());
        workout.setUser(user);
        workoutRepository.save(workout);
    }

    public List<WorkoutResponse> getAllWorkouts(){
        return workoutRepository.findAll().stream().map(workout -> new WorkoutResponse(workout.getWorkoutTitle(), workout.getDate(), workout.getId(), workout.getUser().getId())).toList();
    }

    public WorkoutResponse getWorkoutById(Long id){
        Workout workout = workoutRepository.findById(id).orElseThrow(() -> new IllegalStateException("Workout not found!"));
        return new WorkoutResponse(workout.getWorkoutTitle(), workout.getDate(), workout.getId(), workout.getUser().getId());
    }

    public void deleteWorkoutById(Long id){
        workoutRepository.deleteById(id);
    }

    public WorkoutUpdateRequest updateWorkoutById(Long id, WorkoutUpdateRequest workoutUpdateRequest){
        Workout exisitingWorkout = workoutRepository.findById(id).orElseThrow(() -> new IllegalStateException("Workout not found!"));
        exisitingWorkout.setWorkoutTitle(workoutUpdateRequest.workoutTitle());
        exisitingWorkout.setDate(workoutUpdateRequest.date());
        workoutRepository.save(exisitingWorkout);
        return new WorkoutUpdateRequest(exisitingWorkout.getWorkoutTitle(), exisitingWorkout.getDate());
    }

}
