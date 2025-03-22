package com.example.pdp_project.controller;


import com.example.pdp_project.dto.QuestionDTO;
import com.example.pdp_project.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public HttpEntity<?> getQuestion() {
        List<QuestionDTO> allQuestions = questionService.getAllQuestions();
        return ResponseEntity.ok(allQuestions);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getQuestion(@PathVariable("id") Integer id) {
        QuestionDTO questionById = questionService.getQuestionById(id);
        return ResponseEntity.ok(questionById);
    }

    @PostMapping
    public HttpEntity<?> createQuestion(@RequestBody QuestionDTO question) {
        QuestionDTO question1 = questionService.createQuestion(question);
        return ResponseEntity.ok(question1);
    }


    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteQuestion(@PathVariable("id") Integer id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/questions/{id}")
    public HttpEntity<?> getQuestionsByLessonId(@PathVariable("id") Integer id) {
        List<QuestionDTO> questionsbyLessonId = questionService.getQuestionsbyLessonId(id);
        return ResponseEntity.ok(questionsbyLessonId);
    }

}
