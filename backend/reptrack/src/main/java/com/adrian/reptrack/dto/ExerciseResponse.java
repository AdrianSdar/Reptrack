package com.adrian.reptrack.dto;

public record ExerciseResponse (String exerciseName, int sets, int reps, double weight, Long id, Long workoutId){}
