package com.example.pdp_project.repo;

import com.example.pdp_project.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
  }