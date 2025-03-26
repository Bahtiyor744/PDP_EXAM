package com.example.pdp_project.controller;


import com.example.pdp_project.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lesson")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    @GetMapping
    public HttpEntity<?> getLessons() {
        return ResponseEntity.ok(lessonService.getAllLessons());
    }

    @GetMapping("/byModuleId/{moduleId}")
    public HttpEntity<?> getLessonByModuleId(@PathVariable("moduleId") Integer moduleId) {
        return ResponseEntity.ok(lessonService.getLessonsByModuleId(moduleId));
    }

//    @GetMapping("/{id}")
//    public HttpEntity<?> getLessonById(@PathVariable("id") Integer id){
//        return ResponseEntity.ok(lessonService.getLessonById(id));
//
//    }
//    @PostMapping
//    public HttpEntity<?> addLesson(@RequestBody LessonDto lessonDto) {
//        LessonDto lessonDto1 = lessonService.createLesson(lessonDto);
//        return ResponseEntity.status(HttpStatus.CREATED).body(lessonDto1);
//    }
//    @DeleteMapping("/{id}")
//    public HttpEntity<?> deleteLessonById(@PathVariable("id") Integer id) {
//        lessonService.getLessonById(id);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
}
