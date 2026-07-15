package com.adrian.reptrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adrian.reptrack.entity.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Long>{}
