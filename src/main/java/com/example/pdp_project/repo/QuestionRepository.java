package com.example.pdp_project.repo;

import com.example.pdp_project.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findAllByLesson_Id(Integer lessonId);
}