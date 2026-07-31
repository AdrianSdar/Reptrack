package com.adrian.reptrack.dto;

import java.time.LocalDate;

public record WorkoutUpdateRequest (String workoutTitle, LocalDate date) {}
