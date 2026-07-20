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
import com.adrian.reptrack.entity.Exercise;
import com.adrian.reptrack.service.ExerciseService;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService){
        this.exerciseService = exerciseService;
    }

    @PostMapping
    public String createExercise(@RequestBody Exercise exercise){
        exerciseService.createExercise(exercise);
        return "Exercise has been created!"; 
    }

    @GetMapping
    public List<Exercise> getAllExercises(){
        return exerciseService.getAllExercises();
    }

    @GetMapping("/{id}")
    public Exercise getExerciseById(@PathVariable Long id){
        return exerciseService.getExerciseById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteExerciseById(@PathVariable Long id){
        exerciseService.deleteExerciseById(id);
    }

    @PutMapping("/{id}")
    public Exercise updateExerciseById(@PathVariable Long id, @RequestBody Exercise exercise){
        return exerciseService.updateExerciseById(id, exercise);
    }
}
