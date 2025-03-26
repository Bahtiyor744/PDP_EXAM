package com.example.pdp_project.controller;

import com.example.pdp_project.service.DegreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rating")
@RequiredArgsConstructor
public class RatingController {
    private final DegreeService degreeService;

    @GetMapping("/byCourse/{courseId}")
    public HttpEntity<?> getRatingByCourse(@PathVariable("courseId") Integer courseId) {
        return ResponseEntity.ok(degreeService.getRatingByCourseId(courseId));
    }
    @GetMapping("/{currentUserID}")
    public HttpEntity<?> getRating(@PathVariable("currentUserID") Integer userID) {
        return ResponseEntity.ok(degreeService.getRating(userID));
    }
}
