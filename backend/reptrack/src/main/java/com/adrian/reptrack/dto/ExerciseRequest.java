package com.adrian.reptrack.dto;

public record ExerciseRequest(String exerciseName, int sets, int reps, double weight, Long workoutId) {}
