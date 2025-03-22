package com.example.pdp_project.repo;

import com.example.pdp_project.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    List<Answer> findAllByQuestion_Id(Integer questionId);
}