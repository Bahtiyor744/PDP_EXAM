package com.example.pdp_project.controller;

import com.example.pdp_project.dto.UsersAnswerDTO;
import com.example.pdp_project.service.DegreeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/degree")
@RequiredArgsConstructor
public class DegreeController {
    private final DegreeService degreeService;

    @PostMapping
    public ResponseEntity<?> check (@RequestBody @Valid UsersAnswerDTO usersAnswerDTO) {
        return ResponseEntity.ok(degreeService.checkAnswers(usersAnswerDTO));
    }


}
