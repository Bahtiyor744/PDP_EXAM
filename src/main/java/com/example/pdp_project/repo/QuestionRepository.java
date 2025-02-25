package com.example.pdp_project.repo;

import com.example.pdp_project.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
  }