package com.example.pdp_project.controller;


import com.example.pdp_project.dto.AnswerDTO;
import com.example.pdp_project.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @GetMapping
    public HttpEntity<?> getAnswer() {
        List<AnswerDTO> allAnswers = answerService.getAllAnswers();
        return ResponseEntity.ok(allAnswers);
    }


    @GetMapping("/{id}")
    public HttpEntity<?> getAnswer(@PathVariable Integer id) {
        AnswerDTO answerById = answerService.getAnswerById(id);
        return ResponseEntity.ok(answerById);
    }

    @PostMapping
    public HttpEntity<?> addAnswer(@RequestBody AnswerDTO answerDTO) {
        AnswerDTO answer = answerService.createAnswer(answerDTO);
        return ResponseEntity.ok(answer);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteAnswer(@PathVariable Integer id) {
        answerService.deleteAnswer(id);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping("/answers/{id}")
//    public HttpEntity<?> getAnswersByQuestionsId(@PathVariable Integer id) {
//        List<AnswerDTO> answerByQuestionsId = answerService.getAnswerByQuestionsId(id);
//        return ResponseEntity.ok(answerByQuestionsId);
//    }

}
