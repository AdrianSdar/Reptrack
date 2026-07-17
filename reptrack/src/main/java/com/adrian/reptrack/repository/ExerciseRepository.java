package com.adrian.reptrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.adrian.reptrack.entity.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long>{}
