package com.adrian.reptrack.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.adrian.reptrack.entity.Workout;
import com.adrian.reptrack.service.WorkoutService;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService){
        this.workoutService = workoutService;
    }

    @PostMapping("/createworkout")
    public String createWorkout (@RequestBody Workout workout){
        workoutService.createWorkout(workout);
        return "Workout has been created";
    }
    
}
