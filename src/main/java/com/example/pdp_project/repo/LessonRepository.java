package com.example.pdp_project.repo;

import com.example.pdp_project.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    List<Lesson> findAllByModule_Id(Integer moduleId);
}