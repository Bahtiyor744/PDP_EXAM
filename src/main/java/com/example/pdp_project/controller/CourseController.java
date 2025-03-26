package com.example.pdp_project.controller;

import com.example.pdp_project.dto.CourseDTO;
import com.example.pdp_project.dto.CoursePostDTO;
import com.example.pdp_project.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") Integer id) {
//        return ResponseEntity.ok(courseService.getCourseById(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<CourseDTO> addCourse(@RequestBody @Valid CoursePostDTO courseDTO) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.createCourse(courseDTO));
//    }
//
//    @PutMapping()
//    public ResponseEntity<CourseDTO> updateCourse(@RequestBody @Valid CourseDTO courseDTO) {
//        return ResponseEntity.ok(courseService.updateCourse(courseDTO));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCourseById(@PathVariable("id") Integer id) {
//        courseService.deleteCourse(id);
//        return ResponseEntity.noContent().build();
//    }
}
