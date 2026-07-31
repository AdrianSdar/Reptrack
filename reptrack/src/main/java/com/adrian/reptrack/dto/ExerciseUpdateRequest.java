package com.adrian.reptrack.dto;

public record ExerciseUpdateRequest (String exerciseName, int sets, int reps, double weight) {}
