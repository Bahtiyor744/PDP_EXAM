package com.example.pdp_project.repo;

import com.example.pdp_project.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
  }