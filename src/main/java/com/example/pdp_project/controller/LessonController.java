package com.example.pdp_project.controller;


import com.example.pdp_project.dto.LessonDto;
import com.example.pdp_project.dto.ModuleDTO;
import com.example.pdp_project.entity.Lesson;
import com.example.pdp_project.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    @GetMapping
    public HttpEntity<?> getLessons() {
        return ResponseEntity.ok(lessonService.getAllLessons());
    }


    @GetMapping("/{id}")
    public HttpEntity<?> getLessonById(@PathVariable("id") Integer id){
            LessonDto lessonById = lessonService.getLessonById(id);
            return ResponseEntity.ok(lessonById);

    }

    @PostMapping
    public HttpEntity<?> addLesson(@RequestBody LessonDto lessonDto) {
        LessonDto lessonDto1 = lessonService.createLesson(lessonDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(lessonDto1);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteLessonById(@PathVariable("id") Integer id) {
        lessonService.getLessonById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/lessons/{id}")
    public HttpEntity<?> getLessonByModuleId(@PathVariable("id") Integer id) {
        List<LessonDto> lessonsByModuleId = lessonService.getLessonsByModuleId(id);
        return ResponseEntity.ok(lessonsByModuleId);
    }


}
