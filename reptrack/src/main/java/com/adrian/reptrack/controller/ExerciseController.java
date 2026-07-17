package com.adrian.reptrack.controller;

import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/createExercise")
    public String createExercise(@RequestBody Exercise exercise){
        exerciseService.createExercise(exercise);
        return "Exercise has been created!"; 
        //Kontrollera alla filer med chatgpt sen pusha
    }
}
