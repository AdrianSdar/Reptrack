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
import com.adrian.reptrack.entity.Workout;
import com.adrian.reptrack.service.WorkoutService;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService){
        this.workoutService = workoutService;
    }

    @PostMapping
    public String createWorkout (@RequestBody Workout workout){
        workoutService.createWorkout(workout);
        return "Workout has been created";
    }

    @GetMapping
    public List<Workout> getAllWorkouts(){
        return workoutService.getAllWorkouts();
    }

    @GetMapping("/{id}")
    public Workout getWorkoutById(@PathVariable Long id){
        return workoutService.getWorkoutById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkoutById(@PathVariable Long id){
        workoutService.deleteWorkoutById(id);
    }

    @PutMapping("/{id}")
    public Workout updateWorkoutById(@PathVariable Long id, @RequestBody Workout workout){
        return workoutService.updateWorkoutById(id, workout);
    }
    
}
