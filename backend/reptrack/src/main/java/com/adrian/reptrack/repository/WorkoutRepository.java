package com.adrian.reptrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.adrian.reptrack.entity.Workout;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long>{}
