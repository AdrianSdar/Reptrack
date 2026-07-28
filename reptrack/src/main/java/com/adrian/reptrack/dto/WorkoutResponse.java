package com.adrian.reptrack.dto;

import java.time.LocalDate;

public record WorkoutResponse(String workoutTitle, LocalDate date, Long id, Long userId) {}
