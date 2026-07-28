package com.adrian.reptrack.dto;

import java.time.LocalDate;

public record WorkoutRequest (String workoutTitle, LocalDate date, Long userId) {}
