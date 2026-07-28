package com.adrian.reptrack.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrian.reptrack.dto.WorkoutRequest;
import com.adrian.reptrack.dto.WorkoutResponse;
import com.adrian.reptrack.dto.WorkoutUpdateRequest;
import com.adrian.reptrack.service.WorkoutService;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService){
        this.workoutService = workoutService;
    }

    @PostMapping
    public String createWorkout (@RequestBody WorkoutRequest workoutRequest){
        workoutService.createWorkout(workoutRequest);
        return "Workout has been created";
    }

    @GetMapping
    public List<WorkoutResponse> getAllWorkouts(){
        return workoutService.getAllWorkouts();
    }

    @GetMapping("/{id}")
    public WorkoutResponse getWorkoutById(@PathVariable Long id){
        return workoutService.getWorkoutById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkoutById(@PathVariable Long id){
        workoutService.deleteWorkoutById(id);
    }

    @PutMapping("/{id}")
    public WorkoutUpdateRequest updateWorkoutById(@PathVariable Long id, @RequestBody WorkoutUpdateRequest workoutUpdateRequest){
        return workoutService.updateWorkoutById(id, workoutUpdateRequest);
    }
    
}
